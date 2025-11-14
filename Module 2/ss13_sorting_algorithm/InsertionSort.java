package ss13_sorting_algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=0;
        while (true){
            try{
                System.out.println("Enter a number:  ");
                n=sc.nextInt();
                if(n<=0){
                    System.out.println("Please enter again!");
                    continue;
                }
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Please enter again!");
                sc.nextLine();
            }
        }
        int []arr=new int[n];
        System.out.println("Enter the element in array.");
        for(int i=0;i<n;i++){
            while (true){
                try{
                    System.out.println("Arr: "+(i+1));
                    arr[i]=sc.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("Please  enter again!");
                    sc.nextLine();
                }
            }
        }
        System.out.println("Array: ");
        printArray(arr);
        System.out.println("arrangement steps: ");
        insertionSort(arr);
        System.out.println("Array after sort:");
        printArray(arr);
        sc.close();

    }
    public static void insertionSort(int[] arr){
        for( int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            System.out.println("\nStep " + i + ": insert element " + key);
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
            System.out.println("Result afrer step: "+i);
            printArray(arr);
        }
    }
    public static void printArray( int[] arr){
        for(int num:arr){
            System.out.print(num+" ");

        }
        System.out.println();
    }
}
