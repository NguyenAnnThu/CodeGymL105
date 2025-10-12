package Loop_Array;

import java.util.Scanner;

public class Prime_Number_100 {
    public static void main(String[] args) {
         int n=2;
        System.out.println("Prime < 100:");
        while(n<100){
            if(Is_Prime(n)){
                System.out.print(n + " ");
            };
            n++;

        }
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
