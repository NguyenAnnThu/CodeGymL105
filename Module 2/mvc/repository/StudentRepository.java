package mvc.repository;

import mvc.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private  static List<Student> students = new ArrayList<>();
    public List<Student> findAll() {
        return students;
    }
    public void add (Student student){
        students.add(student);
    }
    public void update(Student student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==student.getId()){
                students.set(i,student);
                break;
            }
        }
    }
    public void delete(int id){
        for(int i=0;i<students.size();i++){
            Student s=students.get(i);
            if(s.getId()==id){
                students.remove(i);
                return;
            }
        }
    }
    public Student findById(int id){
        for(Student s: students){
            if(s.getId()==id){
                return s;
            }
        }
        return null;
    }
}
