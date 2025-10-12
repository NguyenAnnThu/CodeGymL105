package Loop_Array;

import java.util.Scanner;

public class Delete_index {
    public static void main(String[] args) {


        double [] arr= {2,8.9,10,48,22,19,46,81};
        int index=-1;
        System.out.println("Array:");
        for (int i = 0; i <arr.length-1 ; i++) {
            System.out.print(" "+ arr[i]+" " );
        }
        Scanner sc= new Scanner(System.in);
        double number= sc.nextDouble();
        for (int i = 0; i <=arr.length-1 ; i++) {
            if(arr[i]==number){
                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("Number is not in array");
        }
        else{
            for (int i = index; i <arr.length-1 ; i++) {
                arr[i]=arr[i+1];
            }
        }
        System.out.println("New array:");
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(" "+ arr[i]+" ");
        }
        sc.close();
    }
}

