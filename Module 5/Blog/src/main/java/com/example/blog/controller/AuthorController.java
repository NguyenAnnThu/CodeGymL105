package com.example.blog.controller;

import com.example.blog.entity.Author;
import com.example.blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public String list(Model model){
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("author",new Author());
        return "author/index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Author author){
        authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("author",authorService.findById(id));
        return "author/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Author author){
        authorService.update(id,author);
        return "redirect:/authors";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        authorService.deleteById(id);
        return "redirect:/authors";
    }

}
