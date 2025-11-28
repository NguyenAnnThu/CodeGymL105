package casestudy.repository;

import casestudy.common.CheckInput;
import casestudy.entity.Category;
import casestudy.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProductRepository {
    private final String file="D:\\CodeGym\\Module2\\Module2\\src\\casestudy\\common\\product";
    private final String expirerFile="D:\\CodeGym\\Module2\\Module2\\src\\casestudy\\common\\expired";

    public List<Product> findAll(){
        List<String> lines= CheckInput.readFile(file);
        List<Product> out= new ArrayList<>();
        for(String l: lines){
           out.add(Product.parse(l));
        }
        return out;
    }
    public List<Product> findExpired(){
        List<String> lines = CheckInput.readFile(expirerFile);
        List<Product> out = new ArrayList<>();
        for (String l : lines) {
            out.add(Product.parse(l));
        }
        return out;
    }
    public boolean addProduct(Product p){
        CheckInput.appendFile(file,p.toFile());
        return true;
    }
    public boolean updateProduct(String id, int option){
        List<Product> all= findAll();
        boolean updated=false;

        for(Product p: all){
            if(p.getId().equalsIgnoreCase(id)){
                switch (option){
                    case 1 -> p.setQuantity(CheckInput.intInput("Enter new quantity: "));
                    case 2 -> p.setImportPrice(CheckInput.doubleInput("Enter new import price: "));
                    case 3 -> p.setSellPrice(CheckInput.doubleInput("Enter new sell price: "));
                    default -> {
                        return false;
                    }
                }
                updated = true;
                break;
            }
        }
        if (updated) rewriteFile(all);
        return updated;
    }
    public boolean deleteByID(String id){
        List<Product> delete=findAll();
        boolean removed = delete.removeIf(product -> product.getId().equalsIgnoreCase(id));
        if(removed){
            CheckInput.writerFile(file,delete.stream().map(Product::toFile).toList());
        }
        return removed;
    }
    private void rewriteFile(List<Product> list) {
        List<String> lines = new ArrayList<>();
        for (Product p : list) lines.add(p.toFile());
        CheckInput.writerFile(file, lines);
    }

    public List<Product> searchByName(String name){
        List<Product> search=new ArrayList<>();
        for(Product p: findAll()){
            if(p.getName().toLowerCase().contains(name.toLowerCase())){
                search.add(p);
            }
        }
        return search;
    }
    public List<Product> searchByType(String type){
        List<Product> search= new ArrayList<>();
        for (Product p: findAll()){
            if(p.getType().equalsIgnoreCase(type)){
                search.add(p);
            }
        }
        return search;
    }
    public List<Product> searchByPriceRange(double min, double max){
        List<Product> search=new ArrayList<>();
        for(Product p: findAll()){
            if(p.getSellPrice()>=min&& p.getSellPrice()<=max){
                search.add(p);
            }
        }
        return search;
    }
    public void  autoExpireCheck(){
        List<Product> all= findAll();
        List<Product> expired= new ArrayList<>();
        List<Product> stillGood=new ArrayList<>();

        LocalDate today=LocalDate.now();

        for(Product p: all){
            boolean isExp = CheckInput.isNearExpiry(p.getExpiredDate(), today, 7);
            if (isExp) {
                expired.add(p);
            } else {
                stillGood.add(p);
            }
        }

        List<String> remain= new ArrayList<>();
        for (Product p: stillGood) remain.add(p.toFile());
        CheckInput.writerFile(file,remain);

        List<Product> oldExpired=findExpired();
        oldExpired.addAll(expired);

        List<Product> uniq= new ArrayList<>();
        for (Product p: oldExpired){
            if(uniq.stream().noneMatch(x-> x.getId().equalsIgnoreCase(p.getId()))){
                uniq.add(p);
            }
        }
        List<String> expLines=new ArrayList<>();
        for(Product p: uniq){
            expLines.add(p.toFile());
        }
        CheckInput.writerFile(expirerFile,expLines);

    }

    public  boolean deleteExpiredById(String id){
        List<Product> exp = findExpired();
        boolean removed = false;

        List<Product> newList = new ArrayList<>();
        for (Product p : exp) {
            if (p.getId().equalsIgnoreCase(id)) {
                removed = true;
            } else newList.add(p);
        }

        // rewrite expired list
        List<String> lines = new ArrayList<>();
        for (Product p : newList) lines.add(p.toFile());
        CheckInput.writerFile(expirerFile, lines);

        return removed;
    }
    public boolean buyProduct(String id, int qty) {
        List<Product> list = findAll();
        boolean done = false;

        for (Product p : list) {
            if (p.getId().equalsIgnoreCase(id)) {
                if (qty > p.getQuantity()) return false;
                p.setQuantity(p.getQuantity() - qty);
                done = true;
                break;
            }
        }

        if (done) rewriteFile(list);
        return done;
    }
    public Product findById(String id) {
        for (Product p : findAll()) {
            if (p.getId().equalsIgnoreCase(id)) return p;
        }
        return null;
    }
}
