package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Blog create(Blog blog);
    Blog findById(int id);
    Page<Blog> findAll(Pageable pageable);
    Blog update(int id,Blog blog);
    void deleteById(int id);
    List<Blog> searchByTitle(String keyword);
}
