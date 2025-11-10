package ss11_Stack_Queue;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int decimal=0;
        while(true){
            try{
                System.out.println("Nhap so thap phan: ");
                decimal= sc.nextInt();
                if(decimal<0){
                    System.out.println("Vui lòng nhập lại !!!");
                    continue;
                }
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Khong hop le");
                sc.nextLine();
            }
        }
        Stack<Integer> stack=new Stack<>();
        int num= decimal;
        if (num == 0) {
            System.out.println("Số nhị phân là :"+num);
            return;
        }
        while(num>0){
            stack.push(num%2);
            num=num/2;
        }
        System.out.println("So nhi phan la: ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}
