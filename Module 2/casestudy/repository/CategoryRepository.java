package casestudy.repository;

import casestudy.common.CheckInput;
import casestudy.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private final String file="D:\\CodeGym\\Module2\\Module2\\src\\casestudy\\common\\category";

    public List<Category> findAll(){
        List<String> lines= CheckInput.readFile(file);
        List<Category> out= new ArrayList<>();
        for(String l: lines){
            Category c= Category.parse(l);
            if(c!=null) out.add(c);
        }
        return out;
    }
    public Category findById(String id){
        for (Category c : findAll()) {
            if (c.getId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }
    public Category findByName(String name){
        for (Category c : findAll()) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }
    public boolean save(Category c) {
        List<Category> list = findAll();
        for (Category i : list) {
            if (i.getId().equalsIgnoreCase(c.getId())) {
                System.out.println("Category ID already exist!");
                return false;

            }
        }
        CheckInput.appendFile(file, c.toFile());
        return true;
    }
}
