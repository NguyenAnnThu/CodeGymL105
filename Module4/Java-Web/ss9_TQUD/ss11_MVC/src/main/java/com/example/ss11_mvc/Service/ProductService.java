package com.example.ss11_mvc.Service;

import com.example.ss11_mvc.Entity.Product;
import com.example.ss11_mvc.Repository.IProductRepository;
import com.example.ss11_mvc.Repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productService=new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productService.add(product);
    }

    @Override
    public boolean update(Product product) {
        return productService.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productService.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }
}
