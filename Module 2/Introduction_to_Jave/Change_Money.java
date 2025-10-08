package Introduction_to_Jave;

import java.util.Scanner;

public class Change_Money {
    public static void main(String[] args) {
        final double rate=23000;
        System.out.println("How much do you want to change? ");
        Scanner money=new Scanner(System.in);
        double USD= money.nextDouble();
        double VND=USD*rate;
        System.out.println("Your money: " +VND);
    }
}
