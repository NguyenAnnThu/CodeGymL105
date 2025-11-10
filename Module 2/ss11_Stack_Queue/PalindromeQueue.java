package ss11_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Nhap chuoi: ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Vui long nhap lai");
            } else {
                break;
            }
        }

        String string = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for(char ch: string.toCharArray()){
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome=true;
        while (!stack.isEmpty()){
            if(stack.pop() != queue.remove() ){
                isPalindrome=false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println(input+" la Palindrome");
        }
        else {
            System.out.println(input+" khong phai la Palindrome");
        }
    }

}
