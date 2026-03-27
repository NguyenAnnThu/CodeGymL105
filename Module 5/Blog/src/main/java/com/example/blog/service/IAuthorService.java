package com.example.blog.service;

import com.example.blog.entity.Author;

import java.util.List;

public interface IAuthorService {
    Author createAuthor(Author author);
    Author findById(int id);
    List<Author> findAll();
    Author update(int id,Author author);
    void deleteById(int id);
}
