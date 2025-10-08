package Introduction_to_Jave;

import java.util.Scanner;

public class Number_to_String {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int number;
       do{
           System.out.println("Enter your number:");
           number=sc.nextInt();
           if (number<0 || number>999){
               System.out.println("Nhập lại");
           }

       }while(number<0|| number>999);
        System.out.println(ChangeNumbertoString(number));
    }

    private static String ChangeNumbertoString(int number) {
        String word= "";
        if(number==0){
            System.out.println("Zero");
        }
         int hangTram=number/100;
        int hangchuc=number%100;

        if(hangTram>0){
            word+=ReadOneNumber(hangTram) + " hundreds";
            if (hangchuc>0){
                word+= " and ";

            }
        }
        if(hangchuc>0){
            if(hangchuc<10){
                word+=" "+ ReadOneNumber(hangchuc);
            }
            else if(hangchuc<20){
                word+= " "+ ReadTwoNumber(hangchuc);
            }
            else{
                int ten =hangchuc/10;
                int one=hangchuc%10;
                word+=" " + ReadtenWord(ten);
                if(one>0){
                    word+= " "+ ReadOneNumber(one);
                }

            }
        }
        return word;
    }

    private static String ReadtenWord(int ten) {
        switch (ten){
            case 2: return "twenty";
            case 3: return "thirdty";
            case 4: return "fourty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return "";

        }
    }

    private static String ReadTwoNumber(int hangchuc) {
        switch (hangchuc){
            case 10: return "ten";
            case 11: return "elevent";
            case 12: return "twelve";
            case 13: return "thirdteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default:return  "";
        }
    }

    private static String ReadOneNumber(int hangTram) {
        switch (hangTram){
            case 0: return "Zero";
            case 1: return "one";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return  "";
        }
    }
}
