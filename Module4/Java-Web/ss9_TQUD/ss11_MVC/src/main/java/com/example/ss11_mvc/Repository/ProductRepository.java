package com.example.ss11_mvc.Repository;

import com.example.ss11_mvc.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1,"Bánh Chocopie",120,"2026-01-15"));
        productList.add(new Product(2,"Kẹo dẻo Haribo",200,"2025-12-20"));
        productList.add(new Product(3,"Bánh Oreo",150,"2026-03-10"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        productList.add(product);
        return true;
    }


    @Override
    public boolean delete(int id) {
        return productList.removeIf(p -> p.getId() == id);
    }
    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


    @Override
    public boolean update(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setQuantity(product.getQuantity());
                p.setExpirationDate(product.getExpirationDate());
                return true;
            }
        }
        return false;
    }


}
