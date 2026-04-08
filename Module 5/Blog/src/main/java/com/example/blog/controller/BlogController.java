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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
//@RestController
//@RequestMapping("/api/v1/blog")

public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IAuthorService authorService;

    //
    @GetMapping("")
    public String listBlogPage(Model model) {

        Pageable pageable = PageRequest.of(0, 5);
        Page<Blog> blogPage = blogService.findAll(pageable);

        model.addAttribute("blog", blogPage);
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "blog/list";
    }
    @GetMapping("/{id}")
    public String blogDetail(@PathVariable ("id") int id, Model model) {

        Blog blog = blogService.findById(id);
        if (blog == null) {
            return "redirect:/blog";
        }

        model.addAttribute("blog", blog);
        return "blog/detail";
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        blogService.create(blog);
        return ResponseEntity.ok("Create success");
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> updateBlog(
            @PathVariable int id,
            @RequestBody Blog updatedBlog) {

        Blog blog = blogService.findById(id);
        if (blog == null) {
            return ResponseEntity.notFound().build();
        }

        blog.setTitle(updatedBlog.getTitle());
        blog.setContent(updatedBlog.getContent());
        blog.setCreatedAt(updatedBlog.getCreatedAt());

        Author author = authorService.findById(updatedBlog.getAuthor().getId());
        blog.setAuthor(author);

        Category category = categoryService.findById(updatedBlog.getCategory().getId());
        blog.setCategory(category);

        blogService.update(id, blog);

        return ResponseEntity.ok("Update success");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable int id) {
        blogService.deleteById(id);
        return ResponseEntity.ok("Delete success");
    }

   //AJAX

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogs(@RequestParam("keyword") String keyword) {
        List<Blog> result = blogService.searchByTitle(keyword);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/load")
    public ResponseEntity<List<Blog>> loadMore(
            @RequestParam int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> result = blogService.findAll(pageable);

        return ResponseEntity.ok(result.getContent());
    }
//API
//    @GetMapping("")
//    public ResponseEntity<Page<Blog>> listBlog(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "2") int size) {
//
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Blog> blogPage = blogService.findAll(pageable);
//
//        return ResponseEntity.ok(blogPage);
//    }
////    @GetMapping("/create")
////    public String showCreateForm(Model model){
////        model.addAttribute("blog", new Blog());
////        model.addAttribute("categories", categoryService.findAll());
////        model.addAttribute("authors", authorService.findAll());
////        return "blog/create";
////    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
//        blogService.create(blog);
//        return ResponseEntity.ok("Create success");
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> detail(@PathVariable ("id") int id){
//        Blog blog = blogService.findById(id);
//        if (blog == null) {
//            return ResponseEntity.ok(blog);
//        }
//
//       return ResponseEntity.ok(blog);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateBlog(
//            @PathVariable ("id") int id,
//            @RequestBody Blog updatedBlog
//    ) {
//
//        Blog blog = blogService.findById(id);
//        if (blog == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        blog.setTitle(updatedBlog.getTitle());
//        blog.setContent(updatedBlog.getContent());
//        blog.setCreatedAt(updatedBlog.getCreatedAt());
//
//        Author author = authorService.findById(updatedBlog.getAuthor().getId());
//        blog.setAuthor(author);
//
//        Category category = categoryService.findById(updatedBlog.getCategory().getId());
//        blog.setCategory(category);
//
//        blogService.update(id, blog);
//
//        return ResponseEntity.ok("Update success");
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable int id) {
//        blogService.deleteById(id);
//        return ResponseEntity.ok("Delete success");
//    }
}
