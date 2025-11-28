package casestudy.view;

import casestudy.common.CheckInput;
import casestudy.controller.CustomerController;
import casestudy.controller.SellerController;

import java.util.Scanner;

public class MenuView {
    private final SellerController sellerController;
    private final CustomerController customerController;

    public MenuView(SellerController sellerController, CustomerController customerController) {
        this.sellerController = sellerController;
        this.customerController = customerController;
    }
    public void showMainView(){
        while (true){
            System.out.println("=======Store Product Management=========");
            System.out.println("1. Seller ");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            int ch= CheckInput.intInput("Enter your choice: ");
            switch (ch){
                case 1:
                    sellerController.menu();
                    break;
                case 2:
                    customerController.menu();
                    break;
                case 3:
                    System.out.println("Good bye!!!");
                    break;
                default:
                    System.out.println("Your choice is invalid!!");
            }
        }
    }
}
