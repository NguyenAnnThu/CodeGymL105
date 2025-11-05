package mvc.entity;

import java.time.LocalDate;

public abstract class Person {

    private int id;
    private String name;
    private int age;

    public Person() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "ID: "+ id+"\nName: "+name+"\nAge: "+age;
    }

}
