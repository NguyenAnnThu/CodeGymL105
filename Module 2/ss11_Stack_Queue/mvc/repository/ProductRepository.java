package ss11_Stack_Queue.mvc.repository;

import mvc.entity.Student;
import ss11_Stack_Queue.mvc.entity.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static  List<Products> products= new ArrayList<>();
    public List<Products> findAll(){
        return products;
    }
    public void add(Products p){
        products.add(p);
    }
    public void update(Products p){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==p.getId()){
                products.set(i,p);
                break;
            }
        }
    }
    public void delete(int id){
        for(int i=0;i<products.size();i++){
            Products s=products.get(i);
            if(s.getId()==id){
                products.remove(i);
                return;
            }
        }
    }
    public Products findById(int id){
        for(Products p: products){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    public List<Products> findByName(String name) {
        List<Products> result = new ArrayList<>();
        for (Products p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

}
