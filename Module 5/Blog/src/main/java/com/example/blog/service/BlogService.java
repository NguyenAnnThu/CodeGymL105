package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Blog create(Blog blog) {
        blog.setCreatedAt(LocalDate.now());
        blog.setUpdateAt(LocalDate.now());
        return blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog update(int id, Blog blog) {
        Blog exit=blogRepository.findById(id).orElse(null);
        if(exit == null){
            return  null;
        }
        exit.setTitle(blog.getTitle());
        exit.setContent(blog.getContent());
        exit.setUpdateAt(LocalDate.now());
        return blogRepository.save(exit);
    }

    @Override
    public void deleteById(int id) {
        blogRepository.deleteById(id);
    }
}
