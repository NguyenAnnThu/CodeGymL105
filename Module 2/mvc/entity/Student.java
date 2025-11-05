package mvc.entity;

import java.time.LocalDate;

public class Student extends Person {
    private String major;
    private Float score;

    public Student( ) {
    }

    public Student(int id, String name, int age,String major, Float score) {
        super(id, name, age);
        this.score = score;
        this.major=major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
    @Override
    public String toString(){
        return "Student : \nId: "+ getId()+"\nName: "+getName()
                +"\nAge: "+getAge()+"\nMajor: "+major
                +"\nScore: "+score;
    }

}
