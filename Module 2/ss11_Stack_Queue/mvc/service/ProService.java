package ss11_Stack_Queue.mvc.service;

import ss11_Stack_Queue.mvc.entity.Products;
import ss11_Stack_Queue.mvc.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;

public class ProService implements IService<Products>{
    private ProductRepository ProRepo= new ProductRepository();

    @Override
    public List<Products> findAll() {
        return ProRepo.findAll();
    }

    @Override
    public boolean add(Products p) {
        if(ProRepo.findById(p.getId())!=null){
            return false;
        }
        ProRepo.add(p);
        return true;
    }

    @Override
    public boolean update(Products p) {
        Products old=ProRepo.findById(p.getId());
        if(old==null){
            return false;
        }
        ProRepo.update(p);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Products pt=ProRepo.findById(id);
        if(pt==null){
            return false;
        }
        ProRepo.delete(id);
        return  true;
    }

    @Override
    public Products findById(int id) {
        return ProRepo.findById(id);
    }

    @Override
    public List<Products> findByName(String name) {
        return ProRepo.findByName(name);
    }

    @Override
    public List<Products> sortAscendingByPrice() {
        List<Products> list= ProRepo.findAll();
        list.sort(Comparator.comparingDouble(Products::getPrice));

        return list;
    }

    @Override
    public List<Products> sortDescendingByPrice() {
        List<Products> list= ProRepo.findAll();
        list.sort(Comparator.comparingDouble(Products::getPrice).reversed());

        return list;
    }
}
