package OOP_ss4.Service;

public class student_OOP {
    private String name= "Join";
    private String classes="C02";
    public student_OOP (){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    public void displayStudent(){
        System.out.println("Name: "+name+"\n Class: "+classes);
    }
}
