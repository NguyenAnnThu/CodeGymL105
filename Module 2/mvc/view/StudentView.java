package mvc.view;

import mvc.common.CheckInput;
import mvc.controller.StudentController;
import mvc.entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private static StudentController studentController = new StudentController();

    public void view() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show list of students: ");
            System.out.println("2. Add new students");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Search for student information");
            System.out.println("0. Exist");
            int choice = CheckInput.inputInt("Select function: ");
            switch (choice) {
                case 1:
                    displayStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    findStudent();
                    break;
                case 0:
                    System.out.println("Good bye!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }

    public void displayStudent() {
        List<Student> students = studentController.findAll();
        if(students.isEmpty()){
            System.out.println("List is empty!");
        }else{
            System.out.println("LIST OF STUDENTS:  ");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    public static void addStudent() {
        int id=CheckInput.inputInt(" Enter id: ");
        String name=CheckInput.inputString("Enter name: ");
        int age=CheckInput.inputInt("Enter age: ");
        String major=CheckInput.inputString("Enter major: ");
        float score=CheckInput.inputFloat("Enter score: ");

        studentController.add(new Student(id,name,age,major,score));
    }
    public static void updateStudent() {
        int id=CheckInput.inputInt("Enter ID: ");
        Student st=studentController.findById(id);
        if(st==null){
            System.out.println("Student not found!");
            return;
        }
        System.out.println("1. Update score.");
        System.out.println("2. Update major.");
        int choice=CheckInput.inputInt("Select option: ");
         switch (choice){
             case 1:
                 String newMajor=CheckInput.inputString("Enter new major: ");
                 st.setMajor(newMajor);
                 break;
             case 2:
                 float newScore= CheckInput.inputFloat("Enter new score: ");
                 st.setScore(newScore);
                 break;
             default:
                 System.out.println("Invalid choice!");
                 return;
         }
         studentController.update(st);
        System.out.println("Update successful!");
    }
    public static void deleteStudent(){
        int id=CheckInput.inputInt("Enter id: ");
        Student s= studentController.findById(id);
        if(s==null){
            System.out.println("Student not found!");
        }
        else{
            studentController.delete(id);
        }
    }
    public static void findStudent(){
        int id=CheckInput.inputInt("Enter id: ");
        Student st= studentController.findById(id);
        if(st==null){
            System.out.println("Student not found!");
        }
        else{
            System.out.println("Student information: ");
            System.out.println(st);
        }
    }
}
