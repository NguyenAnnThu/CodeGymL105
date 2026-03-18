package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Products;

import java.util.List;

public interface IProductService {
    List<Products> findAll();
    void add(Products products);
    void  update(Products products);
    void  delete(Products products);
    Products findById(int id);
    List<Products> findByName(String name);
}
