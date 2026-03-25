package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    Blog create(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    Blog update(int id,Blog blog);
    void deleteById(int id);
}
