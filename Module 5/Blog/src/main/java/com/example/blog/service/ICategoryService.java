package com.example.blog.service;

import com.example.blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    void delete(int id);
}
