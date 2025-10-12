package Method;

import java.util.Scanner;

public class Count_String {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String chain="Count the number of occurrences of a character in a string";
        chain=chain.toLowerCase();
        System.out.println("Enter char:");
        char str=sc.next().charAt(0);
        int count=0;
        for (int i = 0; i <chain.length(); i++) {
            if(chain.charAt(i)==str){
                count++;
            }
        }
        System.out.println("Count the number: " + count);
        sc.close();
    }
}
