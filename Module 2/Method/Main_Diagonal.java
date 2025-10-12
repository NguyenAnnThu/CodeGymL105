package Method;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Diagonal {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a,b;
        int [][] Matrix;
        System.out.println("Enter matrix:");
       try{
           do{
               a= sc.nextInt();
               b= sc.nextInt();
               if(a!=b || a<=0 || b<=0){
                   System.out.println("Truy again!");
               }
           }while(a!=b || a<=0|| b<=0 );
       }catch (InputMismatchException e){
           System.out.println("Please enter a number");
           sc.close();
           return;
        }

        Matrix=new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("Item ["+i+"] ["+j+"]: ");
                Matrix[i][j]= sc.nextInt();
            }
        }
        System.out.println("Matrix:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(Matrix[i][j]+"\t");
            }
            System.out.println();
        }
        int sum=0;
        for (int i = 0; i < a; i++) {
            sum+=Matrix[i][i];
        }
        System.out.println("Sum main diagonal:"+ sum);
        sc.close();
    }
}
