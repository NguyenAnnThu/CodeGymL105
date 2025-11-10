package ss11_Stack_Queue;

import mvc.common.CheckInput;

import java.util.Scanner;

public class ReverseStackInt <T>{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        while(true){
            System.out.println("DATA REVERSE PROGRAM");
            System.out.println("1. Reverse the integer array.");
            System.out.println("2. Reverse the string array.");
            System.out.println("0. Exist");
            int choice= sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    reverseIntegers(sc);
                    break;
                case 2:
                    reverseString(sc);
                    break;
                case 3:
                    System.out.println("Good bye!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

    }

    public static void reverseIntegers(Scanner sc) {
        TH_MyGeneric<Integer> stack= new TH_MyGeneric<>();
        System.out.println("Enter items: ");
        int n= sc.nextInt();
        System.out.println(" Enter the elements:");

        for(int i=0;i<n;i++){
            int value=CheckInput.inputInt("Item "+i+" :");
            stack.push(value);
        }

        System.out.println("Array after reversal:");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");

        }
        System.out.println();
    }
    public static void reverseString(Scanner sc){
        TH_MyGeneric<String> stack=new TH_MyGeneric<>();
        System.out.println("Enter String: ");
        String st= sc.nextLine();
        String[] words= st.trim().split("\\s+");

        for(String word: words){
            stack.push(word);
        }
        System.out.println("Array after reverse: ");
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();

    }
}
