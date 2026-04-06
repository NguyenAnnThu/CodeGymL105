package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Category category) {
        categoryService.save(category);
        return ResponseEntity.ok("Create success");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Category newData) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        category.setCategoryName(newData.getCategoryName());
        categoryService.save(category);

        return ResponseEntity.ok("Update success");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        categoryService.delete(id);
        return ResponseEntity.ok("Delete success");
    }

}
