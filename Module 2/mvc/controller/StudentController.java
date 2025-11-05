package mvc.controller;

import mvc.entity.Student;
import mvc.service.IStudentService;
import mvc.service.StudentService;

import java.util.List;

public class StudentController {

    private IStudentService studentService = new StudentService();


    public List<Student> findAll() {
        return studentService.findAll();
    }
    public void add(Student student){
        studentService.add(student);
    }
    public void update(Student student){
        studentService.update(student);
    }
    public void delete(int id){
        studentService.delete(id);
    }
    public Student findById(int id){
        return studentService.findById(id);
    }
}
