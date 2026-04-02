package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.service.IProductService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(
            @CookieValue(value = "last_product", defaultValue = "") String lastProductId) {

        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());

        if (!lastProductId.equals("")) {
            Optional<Product> lastProduct = productService.findById(Long.parseLong(lastProductId));
            lastProduct.ifPresent(product -> modelAndView.addObject("lastProduct", product));
        }

        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action,
                            HttpServletResponse response) {

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }

        // --- Thêm sản phẩm vào cart ---
        cart.addProduct(productOptional.get());

        // --- Lưu vào cookie (dạng JSON hoặc chỉ lưu id cho đơn giản) ---
        String productId = String.valueOf(id);
        Cookie cookie = new Cookie("last_product", productId);

        cookie.setMaxAge(60 * 60 * 24 * 7);  // lưu 7 ngày
        cookie.setPath("/");
        response.addCookie(cookie);

        if (action.equals("show")) {
            return "redirect:/shopping-cart";
        }
        return "redirect:/shop";
    }
}
