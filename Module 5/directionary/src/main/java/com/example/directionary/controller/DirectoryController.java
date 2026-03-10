package com.example.directionary.controller;

import com.example.directionary.service.IWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/directory")
public class DirectoryController {
    @Autowired
    private IWordService dictionaryService;

    @GetMapping("")
    public String showForm(){
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name="word")String word, Model model) {

        String result = dictionaryService.search(word);

        model.addAttribute("word", word);
        model.addAttribute("result", result);

        return "index";
    }
}
