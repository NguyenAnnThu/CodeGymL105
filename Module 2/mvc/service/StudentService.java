package mvc.service;

import mvc.entity.Student;
import mvc.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        if(studentRepository.findById(student.getId())!=null){
            System.out.println("This ID already exists. Cannot add student!\"");
            return;
        }
        studentRepository.add(student);
        System.out.println("More students successfully!");
    }

    @Override
    public void update(Student student) {
        Student old=studentRepository.findById(student.getId());
        if(old==null){
            System.out.println("Student with this ID not found!");
            return;
        }
        studentRepository.update(student);
    }

    @Override
    public void delete(int id) {
        Student st=studentRepository.findById(id);
        if(st==null){
            System.out.println("Student with this ID not found!");
            return;
        }
        studentRepository.delete(id);
        System.out.println("Delete successful!");
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
