package com.example.blog.service;

import com.example.blog.entity.Author;
import com.example.blog.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {

        return authorRepository.save(author);
    }

    @Override
    public Author findById(int id) {

        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAll() {

        return authorRepository.findAll();
    }

    @Override
    public Author update(int id, Author author) {
        Author exit=authorRepository.findById(id).orElse(null);
        if(exit==null){
            return null;
        }
        exit.setName(author.getName());
        exit.setAge(author.getAge());
        exit.setGender(author.getGender());
        return authorRepository.save(exit);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }
}
