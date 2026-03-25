package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String listBlog(Model model){
        model.addAttribute("blog", blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@RequestParam String title,
                           @RequestParam String content){
        Blog blog= new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blogService.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id,
                         Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }

    @PostMapping("/update")
    public String updateBlog(@RequestParam int id,
                             @RequestParam String content){

        Blog old = blogService.findById(id);
        if (old == null) return "redirect:/blog";

        Blog newData = new Blog();
        newData.setTitle(old.getTitle());
        newData.setContent(content);

        blogService.update(id, newData);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public  String delete(@RequestParam int id){
        blogService.deleteById(id);
        return "redirect:/blog";
    }
}
