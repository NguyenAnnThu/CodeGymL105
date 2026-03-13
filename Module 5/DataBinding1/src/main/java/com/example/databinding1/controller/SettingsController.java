package com.example.databinding1.controller;

import com.example.databinding1.entity.Settings;
import com.example.databinding1.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    @GetMapping
    public String showSettings(Model model) {

        List<String> languages = Arrays.asList(
                "English",
                "Vietnamese",
                "Japanese",
                "Chinese"
        );

        List<Integer> pageSizes = Arrays.asList(
                5,10,15,25,50,100
        );

        model.addAttribute("languages", languages);
        model.addAttribute("pageSizes", pageSizes);
        model.addAttribute("settings", settingsService.getSettings());

        return "settings";
    }

    @PostMapping
    public String updateSettings(@ModelAttribute Settings settings, RedirectAttributes redirectAttributes) {

        settingsService.updateSettings(settings);
        redirectAttributes.addFlashAttribute("message", "Update settings successfully!");
        return "redirect:/settings";
    }
}
