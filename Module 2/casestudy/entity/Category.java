package casestudy.entity;

public class Category {
    private String id;
    private String name;
    public Category(){

    }

    public Category(String id, String name){
        this.id=id;
        this.name=name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("%-3s | %-20s", id, name);
    }
    public String toFile(){
        return String.format("%-3s | %-20s", id, name);
    }
    public static Category parse(String line){
        String[] a = line.trim().split("\\s*\\|\\s*");
        if (a.length < 2) return null;
        return new Category(a[0].trim(), a[1].trim());
    }

}
