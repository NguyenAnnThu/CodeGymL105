package com.example.book.service;

import com.example.book.dto.BookDTO;
import com.example.book.dto.BorrowDTO;
import com.example.book.dto.ReturnDTO;
import com.example.book.entity.Book;
import com.example.book.entity.Borrow;
import com.example.book.repository.IBookRepository;
import com.example.book.repository.IBorrowRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Autowired
    private IBorrowRepositry borrowRepository;

    private Random random =new Random();
    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream().map(book->{
                    BookDTO dto=new BookDTO();
                    dto.setId(book.getId());
                    dto.setTitle(book.getTitle());
                    dto.setQuantity(book.getQuantity());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public int borrowBook(BorrowDTO dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if(book.getQuantity()<=0){
            throw new RuntimeException("Book is out of stock");
        }
        book.setQuantity(book.getQuantity()-1);
        bookRepository.save(book);
        int borrowCode=10000 + random.nextInt(90000);
        Borrow record=new Borrow();
        record.setBook(book);
        record.setBorrowCode(borrowCode);
        record.setCreatedAt(LocalDate.now());
        record.setReturned(false);
        borrowRepository.save(record);

        return borrowCode;
    }

    @Override
    @Transactional
    public void returnBook(ReturnDTO dto) {

        Borrow record= borrowRepository.findByBorrowCodeAndReturnedFalse(dto.getBorrowCode())
                .orElseThrow(()-> new RuntimeException("Invalid borrow code"));
        Book book =record.getBook();
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
        record.setReturned(true);
        borrowRepository.save(record);
    }

    @Override
    public BookDTO findById(int id) {
        Book book=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setQuantity(book.getQuantity());
        return dto;
    }
    @Override
    public List<BorrowDTO> findBorrowsByBookId(int bookId) {
        return borrowRepository.findByBook_Id(bookId)
                .stream()
                .map(b -> {
                    BorrowDTO dto = new BorrowDTO();
                    dto.setBookId(b.getBook().getId());
                    dto.setBorrowCode(b.getBorrowCode());
                    dto.setCreatedAt(b.getCreatedAt());
                    dto.setReturned(b.isReturned());
                    return dto;
                }).collect(Collectors.toList());
    }
}
