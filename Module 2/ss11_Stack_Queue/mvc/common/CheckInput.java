package ss11_Stack_Queue.mvc.common;

import ss11_Stack_Queue.mvc.controller.ProController;
import ss11_Stack_Queue.mvc.entity.Products;

import java.util.Scanner;

public class CheckInput {
    private static final Scanner sc= new Scanner(System.in);

    public static int inputInt(String message){
        int number;
        while (true){
            try{
                System.out.println(message);
                number =Integer.parseInt(sc.nextLine().trim());
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
        float price;
        while(true){
            System.out.println(message);
            price=sc.nextFloat();
            if(price< 0 ) {
                System.out.println("Invalid");
            } else {
                return price;
            }
        }
    }
    public static Products input(boolean requireId){
        int id=0;
        if(requireId){
            id=inputInt("Nhap ID: ");
        }
        String name= inputString("Nhap ten: ");
        float price= inputFloat("Nhap gia:");
        int quantity= inputInt("Nhap so luong:");
        return new Products(id,name,price,quantity);
    }

}
