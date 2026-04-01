package com.example.book.service;

import com.example.book.dto.BookDTO;
import com.example.book.dto.BorrowDTO;
import com.example.book.dto.ReturnDTO;

import java.util.List;

public interface IBookService {
    List<BookDTO> findAll();
    int borrowBook(BorrowDTO dto);
    void returnBook(ReturnDTO dto);
    BookDTO findById(int id);
    List<BorrowDTO> findBorrowsByBookId(int bookId);
}
