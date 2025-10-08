package Introduction_to_Jave;

import java.util.Scanner;

public class Hello_Name {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner sc= new Scanner(System.in);
        String Name= sc.nextLine();
        System.out.println("Hello "+ Name);

    }
}
