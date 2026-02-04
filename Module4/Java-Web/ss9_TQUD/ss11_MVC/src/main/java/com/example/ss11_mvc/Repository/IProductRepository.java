package com.example.ss11_mvc.Repository;

import com.example.ss11_mvc.Entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(int id);

    Product findById(int id);
}
