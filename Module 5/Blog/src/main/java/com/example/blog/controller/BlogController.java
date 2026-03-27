package com.example.blog.controller;

import com.example.blog.entity.Author;
import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.IAuthorService;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")

public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService; @Autowired
    private IAuthorService authorService;

    @GetMapping("")
    public String listBlog(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> blogPage = blogService.findAll(pageable);

        model.addAttribute("blogPage", blogPage);
        return "blog/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "blog/create";
    }

    // CREATE BLOG
    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.create(blog);
        return "redirect:/blog";
    }

    // BLOG DETAIL
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        Blog blog = blogService.findById(id);
        if (blog == null) return "redirect:/blog";

        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    // SHOW UPDATE FORM
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Blog blog = blogService.findById(id);
        if (blog == null) return "redirect:/blog";

        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("authors", authorService.findAll());

        return "blog/edit";
    }

    // UPDATE BLOG
    @PostMapping("/update")
    public String updateBlog(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("author.id") int authorId,
            @RequestParam("category.id") int categoryId,
            @RequestParam("createdAt") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate createdAt
    ) {
        // Lấy blog từ DB
        Blog blog = blogService.findById(id);

        blog.setTitle(title);
        blog.setContent(content);

        // Lấy entity Author & Category từ DB
        Author author = authorService.findById(authorId);
        Category category = categoryService.findById(categoryId);

        blog.setAuthor(author);
        blog.setCategory(category);
        blog.setCreatedAt(createdAt);

        blogService.update(id,blog);

        return "redirect:/blog";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        blogService.deleteById(id);
        return "redirect:/blog";
    }
}
