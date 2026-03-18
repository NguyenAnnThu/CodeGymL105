package com.example.thymeleaf.entity;

public class Products {
    private int id;
    private String name;
    private int quantity;
   private String[] type;

    public Products() {
    }

    public Products(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Products(int id, String name, int quantity, String[] type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }
}
