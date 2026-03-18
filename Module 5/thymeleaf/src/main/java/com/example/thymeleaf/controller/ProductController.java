package com.example.thymeleaf.controller;

import com.example.thymeleaf.entity.Products;
import com.example.thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping ("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("type")
    public String[] getType(){
        return new String[]{"Drink","Food","Vegetable"};
    }

    @GetMapping("")
    public String home(ModelMap model){
        List<Products> productsList=productService.findAll();
        model.addAttribute("productList",productsList);
        return "product/home";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("product", new Products());
        return "product/add";
    }

    @PostMapping("/add")
    public String Save(@ModelAttribute Products products,
                       RedirectAttributes redirectAttributes){
        productService.add(products);
        redirectAttributes.addFlashAttribute("mess","Create successfully!");
        return "redirect:/product";
    }
    @GetMapping ("/edit/{id}")
    public String showEdit(@PathVariable(name="id") int id,
                           Model model) {
        Products products = productService.findById(id);
        model.addAttribute("product", products);
        return "product/update";
    }
    @PostMapping ("/update")
    public String update(@ModelAttribute Products products,
                         RedirectAttributes redirectAttributes){
        productService.update(products);
        redirectAttributes.addFlashAttribute("mess","Update successfully!");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id") int id,
                         RedirectAttributes redirectAttributes){
        Products products=productService.findById(id);
        productService.delete(products);
        redirectAttributes.addFlashAttribute("mess","Delete successfully!");
        return "redirect:/product";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable(name="id") int id, Model model){
        Products product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }

    // SEARCH
    @GetMapping("/search")
    public String search(@RequestParam(name="name") String name, Model model){
        List<Products> products=productService.findByName(name);
        model.addAttribute("productList", products);
        return "product/home";
    }
}
