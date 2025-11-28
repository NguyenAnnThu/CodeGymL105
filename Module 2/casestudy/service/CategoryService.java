package casestudy.service;

import casestudy.entity.Category;
import casestudy.repository.CategoryRepository;

import java.util.List;

public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }
    public List<Category> findAll(){
        return repo.findAll();
    }
    public Category findById(String id) {
        return repo.findById(id);
    }
    public Category findByName(String name){
        return  repo.findByName(name);
    }
    public boolean save(Category c) {
        try {
            return repo.save(c);
        } catch (Exception e) {
            System.out.println("Error while saving category: " + e.getMessage());
            return false;
        }
    }
}
