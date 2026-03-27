package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Blog> findByCategoryId(int categoryId,Pageable pageable);
    Page<Blog> findByAuthorId(int authorId,Pageable pageable);
}
