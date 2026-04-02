package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
