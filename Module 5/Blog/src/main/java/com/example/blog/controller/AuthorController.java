package com.example.blog.controller;

import com.example.blog.entity.Author;
import com.example.blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping("")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAll());
    }


    @PostMapping("")
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.ok("Create author successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(
            @PathVariable int id,
            @RequestBody Author newData) {

        Author existing = authorService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        existing.setName(newData.getName());
        existing.setAge(newData.getAge());
        existing.setGender(newData.getGender());

        authorService.update(id, existing);

        return ResponseEntity.ok("Update author successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
        authorService.deleteById(id);
        return ResponseEntity.ok("Delete author successfully");
    }
}
