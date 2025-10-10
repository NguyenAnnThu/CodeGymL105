package Loop_Array;

import java.net.SocketOption;
import java.util.Scanner;

public class Print_Types {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int number, count=5;
        while(true) {
            System.out.println("Please enter your choice: \n 0. The end  \n 1. Print_the_rectangle \n 2.Print_the_square_triangle \n 3. Print_isosceles_triangle ");
            number=sc.nextInt();
            if(number==0||number>3){
                System.out.println("The End");
                break;
            }
            else if(number==1){
                Print_the_rectangle(number);
            }
            else if (number==2){
                Print_the_square_triangle(number);
            }
            else {
               Print_isosceles_triangle(number);
            }
        }
        sc.close();
    }

    private static void Print_isosceles_triangle(int number) {
        for (int i = 5; i>=1 ; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    private static void Print_the_square_triangle(int number) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 2; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void Print_the_rectangle(int number) {
        System.out.println("Rectangle");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println( );
        }
    }

}
