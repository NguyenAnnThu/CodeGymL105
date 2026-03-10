package com.example.sandwichcondiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping("")
    public String showForm() {
        return "home";
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam(name="name") String name,
                             @RequestParam(name="img") String img,
                             Model model) {

        model.addAttribute("sandwichName", name);
        model.addAttribute("image", img);

        return "detail";
    }


    @PostMapping("/save")
    public String saveSauce(@RequestParam(name="name") String name,
                            @RequestParam(name="img") String img,
                            @RequestParam(value="condiment", required=false) String[] condiment,
                            Model model) {

        model.addAttribute("sandwichName", name);
        model.addAttribute("image", img);
        model.addAttribute("condiments", condiment);

        return "detail";
    }
}
