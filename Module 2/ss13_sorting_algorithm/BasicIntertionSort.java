package ss13_sorting_algorithm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicIntertionSort {
    public static  void intersionSort(int[]list){
        for(int i=1;i<list.length;i++){
            int currentElement=list[i];
            int j;
            for(j=i-1;j>=0&& list[j]>currentElement;j--){
                list[j+1]=list[j];
            }
            list[j+1]=currentElement;
        }
    }

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
        int []list =new int[n];
        System.out.println("Enter the element in list.");
        for(int i=0;i<n;i++){
            while (true){
                try{
                    System.out.println("List: "+(i+1));
                    list[i]=sc.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("Please  enter again!");
                    sc.nextLine();
                }
            }
        }
        System.out.println("Array: ");
        printArray(list);
        intersionSort(list);
        System.out.println("Array after sort:");
        printArray(list);
        sc.close();
    }
    public static void printArray(int[] list){
        for(int value:list){
            System.out.print(value+" ");
        }
        System.out.println();
    }
}
