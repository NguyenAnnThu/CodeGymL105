package Loop_Array;

import java.util.Scanner;

public class Prime_Number {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int number= sc.nextInt();
        int count=0;
        int n=2;
        System.out.println("Prime:");
        while(count<number){

           if(Is_Prime(n)){
               System.out.print(n+ " ");
               count++;
           }
           n++;
        }
        sc.close();
    }

    private static boolean Is_Prime(int n) {
        if(n<2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
