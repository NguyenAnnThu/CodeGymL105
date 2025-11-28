package casestudy.service;

import casestudy.entity.Product;
import casestudy.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
    public List<Product> findAll(){
        return repo.findAll();
    }
   public boolean addProduct(Product p){
       try {
           return repo.addProduct(p);
       } catch (Exception e) {
           System.out.println("Error while adding product: " + e.getMessage());
           return false;
       }
   }
   public boolean updateProduct(String id, int option){
       try {

           return repo.updateProduct(id, option);
       } catch (Exception e) {
           System.out.println("Error while updating product: " + e.getMessage());
           return false;
       }
   }
   public List<Product> searchByName(String name){
        return  repo.searchByName(name);
   }
   public List<Product> searchByType(String type){
        return repo.searchByType(type);
   }
   public List<Product> searchByRange(double min, double max){
        return repo.searchByPriceRange(min,max);
   }
   public void autoExpiredCheck() {
       try {
           repo.autoExpireCheck();
       } catch (Exception e) {
           System.out.println("Error while checking expired products: " + e.getMessage());
       }
   }
   public List<Product> getExpiredList(){
        return repo.findExpired();
   }
   public boolean deleteExpiredById(String id){
       try {
           return repo.deleteExpiredById(id);
       } catch (Exception e) {
           System.out.println("Error while deleting expired product: " + e.getMessage());
           return false;
       }
   }
   public boolean deleteById(String id){
        return repo.deleteByID(id);
   }
   public boolean buyProduct(String id, int qty){
        return repo.buyProduct(id, qty);
   }
   public Product findById(String id){
        return repo.findById(id);
   }
}
