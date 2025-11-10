package ss11_Stack_Queue.mvc.service;

import ss11_Stack_Queue.mvc.entity.Products;

import java.util.List;

public interface IService <T>{

    List<T> findAll();
    boolean add(T t);
    boolean update(T t);
    boolean delete(int id);
    T findById(int id);
    List<T> findByName(String name);
    List<Products> sortAscendingByPrice();
    List<Products> sortDescendingByPrice();
}
