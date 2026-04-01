package com.example.book.controller;

import com.example.book.dto.BookDTO;
import com.example.book.dto.BorrowDTO;
import com.example.book.dto.ReturnDTO;
import com.example.book.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;


    @GetMapping("")
    public String listBooks(Model model){
        List<BookDTO> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/{id}")
    public String bookDetail(@PathVariable("id") int id, Model model){
        BookDTO book = bookService.findById(id);
        model.addAttribute("book", book);

        List<BorrowDTO> borrows = bookService.findBorrowsByBookId(id);
        model.addAttribute("borrows", borrows);

        return "books/detail";
    }
    @GetMapping("/{id}/borrow")
    public String borrowForm(@PathVariable ("id")int id, Model model){
        BorrowDTO borrowDTO = new BorrowDTO();
        borrowDTO.setBookId(id);

        model.addAttribute("dto", borrowDTO);
        return "books/borrow";
    }

    // Xử lý mượn
    @PostMapping("/{id}/borrow")
    public String borrowBook(@ModelAttribute("dto") BorrowDTO dto){
        int code=bookService.borrowBook(dto);
        return "redirect:/book/" + dto.getBookId();
    }
    @GetMapping("/return")
    public String returnForm(Model model) {
        model.addAttribute("dto", new ReturnDTO());
        return "books/return";
    }

    // --- RETURN ACTION ---
    @PostMapping("/return")
    public String returnBook(@ModelAttribute("dto") ReturnDTO dto) {
        bookService.returnBook(dto);
        return "redirect:/book";
    }
}
