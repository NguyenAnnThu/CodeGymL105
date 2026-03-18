package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {
    private  static List<Products> productsList = new ArrayList<>();
    static {
        productsList.add(new Products(1,"Milk",20,List.of("Drink", "Food", "Vegetable").toArray(new String[0])));
        productsList.add(new Products(2,"Orange Juice",15,List.of("Drink", "Food", "Vegetable").toArray(new String[0])));
        productsList.add(new Products(3,"Bread",30,List.of("Drink", "Food", "Vegetable").toArray(new String[0])));
    }

    @Override
    public List<Products> findAll() {
        return productsList;
    }

    @Override
    public void add(Products products) {
        productsList.add(products);

    }

    @Override
    public void update(Products products) {
        for(int i=0; i< productsList.size();i++){
            if(productsList.get(i).getId()== products.getId()){
                productsList.set(i,products);
                break;
            }
        }


    }

    @Override
    public void delete(Products products) {
        productsList.removeIf(p->p.getId()==products.getId());
    }

    @Override
    public Products findById(int id) {
        for(int i=0;i<productsList.size();i++){
            if(id==productsList.get(i).getId()){
                return productsList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Products> findByName(String name) {
        List<Products> result=new ArrayList<>();
        if(name==null || name.trim().isEmpty()){
            return productsList;
        }
        for(Products p: productsList){
            if(p.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(p);
            }
        }
        return result;
    }


}
