package ss12_search_algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n= sc.nextInt();
        int[] array= new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++){
            System.out.println("Elements "+(i+1)+" :");
            array[i]=sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println("The array after sort: "+ Arrays.toString(array));
        System.out.println("Enter a number: ");
         int value= sc.nextInt();
         int result=binarySearch(array,0,array.length-1,value);
         if(result==-1){
             System.out.println("The value " + value + " was not found in the array.");
         }
         else{
             System.out.println("The value "+ value +" was found in the array.");
         }
         sc.close();
    }
    public  static int binarySearch(int[] array,int left,int right,int value){
        if(left>right){
            return  -1;
        }
        int middle= (left+right)/2;
        if(array[middle]==value){
            return middle;
        }
        else if(array[middle]<value){
            return binarySearch(array,middle+1,right,value);
        }
        else {
            return binarySearch(array,left,middle-1,value);
        }
    }
}
