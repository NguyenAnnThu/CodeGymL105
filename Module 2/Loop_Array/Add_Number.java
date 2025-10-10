package Loop_Array;

import java.util.Scanner;

public class Add_Number {
    public static void main(String[] args) {
        int [] arr={1,3,5,7,98,30};
        System.out.println("Array:");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(" "+ arr[i]+" ");
        }
        Scanner sc= new Scanner(System.in);
        System.out.print("\n"+"Your number: ");
        int number=sc.nextInt();
        System.out.print("To insert: ");
        int index=sc.nextInt();
        if(index<0 || index> arr.length){
            System.out.println("Doesn't exist");
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
