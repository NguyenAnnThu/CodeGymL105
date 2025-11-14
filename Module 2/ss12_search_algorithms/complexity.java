package ss12_search_algorithms;

import java.util.Scanner;

public class complexity {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a string :");
        String inputString= sc.nextLine();
        int [] frequentChart=new int[255];
        for(int i=0; i<inputString.length();i++){
            int ascii= (int) inputString.charAt(i);
            frequentChart[ascii]+=1;
        }
        int max=0;
        char character=(char) 255;
        for(int j=0;j<255;j++){
            if(frequentChart[j]>max){
            max=frequentChart[j];
            character= (char) j;
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
