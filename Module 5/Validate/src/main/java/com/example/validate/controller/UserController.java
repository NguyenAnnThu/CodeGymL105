package com.example.validate.controller;

import com.example.validate.DTO.UserDTO;
import com.example.validate.entity.User;
import com.example.validate.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("user",new UserDTO());
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("user") UserDTO userDTO,
                             BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }
        userService.save(userDTO);
        model.addAttribute("user",userDTO);
        return "result";
    }
}
