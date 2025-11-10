package ss11_Stack_Queue.mvc.controller;

import ss11_Stack_Queue.mvc.entity.Products;
import ss11_Stack_Queue.mvc.service.IService;
import ss11_Stack_Queue.mvc.service.ProService;

import java.util.List;

public class ProController {
    private final IService<Products> ProService= new ProService();


    public  List<Products> findAll(){
        return ProService.findAll();
    }
    public boolean add(Products p){
       return ProService.add(p);
    }
    public boolean update(Products p){
        return  ProService.update(p);
    }
    public boolean delete(int id){
        return ProService.delete(id);
    }
    public  List<Products> searchByName(String name){
        return ProService.findByName(name);
    }
    public List<Products> sortAsc(){
        return ProService.sortAscendingByPrice();
    }
    public List<Products> sortDec(){
        return ProService.sortDescendingByPrice();
    }

    public Products findById(int id) {
        return ProService.findById(id);
    }
}
