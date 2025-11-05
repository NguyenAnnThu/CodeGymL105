package mvc.common;

import java.util.Scanner;

public class CheckInput {
    private  static final Scanner sc= new Scanner(System.in);
    public static int inputInt(String message){
        int number;
        while (true){
            try{
                System.out.println(message);
                number=Integer.parseInt(sc.nextLine().trim());
                return number;
            }
            catch (NumberFormatException e){
                System.out.println("Please enter a valid integer!");
            }
        }
    }
    public static String inputString( String message){
        String value;
        while(true){
                System.out.println(message);
                value=sc.nextLine().trim();
                if(!value.isEmpty()) return value;
                System.out.println("invalid!");
        }
    }
    public  static float inputFloat(String message){
        float score;
        while(true){
                System.out.println(message);
                score=sc.nextFloat();
                if(score < 0 || score > 10) {
                    System.out.println("Invalid");
                } else {
                    return score;
                }
        }
    }
}
