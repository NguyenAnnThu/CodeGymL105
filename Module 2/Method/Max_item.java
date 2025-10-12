package Method;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Max_item {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int [][] Matrix;
        int a;
        int b;
        try{
            do {
                a = sc.nextInt();
                if(a<=0){
                    System.out.println("Truy again!");
                }
            }while (a<=0);

            do{
                b=sc.nextInt();
                if(b<=0){
                    System.out.println("Truy again!");
                }
            }while (b<=0);
        }
        catch(InputMismatchException e ){
            System.out.println("Please enter a number");
            sc.close();
            return;
        }

        Matrix= new int[a][b];
        for (int i = 0; i <a ; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println("Item ["+i+"]"+"["+j+"]:");
                Matrix[i][j]=sc.nextInt();
            }
        }
        int max= Matrix[0][0];
        System.out.println("Matrix:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(Matrix[i][j]+"\t");
            }
            System.out.println();
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(Matrix[i][j]>max){
                    max=Matrix[i][j];
                }
            }
        }
        System.out.print("Max item:"+max);
        sc.close();
    }
}
