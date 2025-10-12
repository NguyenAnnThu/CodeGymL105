package Loop_Array;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Add_Number {
    public static void main(String[] args) {
        int [] arr={1,3,5,7,98,30};
        int number,index;
        System.out.println("Array:");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(" "+ arr[i]+" ");
        }
        Scanner sc= new Scanner(System.in);
        try{
            System.out.print("\n"+"Your number: ");
             number=sc.nextInt();
            System.out.print("To insert: ");
           index=sc.nextInt();
            if(index<0 || index> arr.length){
                System.out.println("Doesn't exist");
                sc.close();
                return;
            }
        }catch (InputMismatchException e){
            System.out.println("Please enter a number");
            sc.close();
            return;
        }
        int [] newarr= new int [arr.length+1];
        for (int i = 0; i <newarr.length ; i++) {
            if(i<index){
                newarr[i]+=arr[i];
            }
            else if(i==index){
                newarr[i]=number;
            }
            else{
                newarr[i]=arr[i-1];
            }
        }
        System.out.println("New array:");
        for (int i = 0; i < newarr.length ; i++) {
            System.out.print(" "+ newarr[i]+" ");
        }
    sc.close();
    }
}
