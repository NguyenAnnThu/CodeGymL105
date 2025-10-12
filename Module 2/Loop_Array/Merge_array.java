package Loop_Array;

import java.util.Scanner;

public class Merge_array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of Array 1: ");
        int n1=sc.nextInt();
        int [] array1 = new int [n1];

        for (int i = 0; i <n1 ; i++) {
            System.out.print("Number "+i+" :");
            array1[i]=sc.nextInt();
        }
        System.out.print("Enter number of Array 2:");
        int n2= sc.nextInt();
        int [] array2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            System.out.print("Number "+i+" :");
            array2[i]=sc.nextInt();
        }
        int [] array3= new int [n1+n2];
        for (int i = 0; i < n1; i++) {
            array3[i]=array1[i];
        }
        for (int i = 0; i < n2; i++) {
            array3[n1+i]=array2[i];
        }
        System.out.println(" Array 3: ");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(" "+ array3[i]+" ");
        }
        sc.close();
    }
}
