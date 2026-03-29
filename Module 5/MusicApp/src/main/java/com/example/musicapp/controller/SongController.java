package com.example.musicapp.controller;

import com.example.musicapp.entity.Song;
import com.example.musicapp.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("songs",songService.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("song", new Song());
        return "song/form";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Song song,
                         BindingResult result) {
        if(result.hasErrors()){
            return "song/form";
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "song/form";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Song song,
                       BindingResult result) {
        if(result.hasErrors()){
            return "song/form";
        }
        songService.save(song);
        return "redirect:/songs";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        songService.delete(id);
        return "redirect:/songs";
    }
}
