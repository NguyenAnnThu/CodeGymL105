package casestudy.controller;

import casestudy.common.CheckInput;
import casestudy.entity.Product;
import casestudy.service.CategoryService;
import casestudy.service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Scanner sc;

    public CustomerController(ProductService productService, CategoryService categoryService, Scanner sc) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.sc = sc;
    }
    public void menu(){
        while (true){
            System.out.println("========Customer Menu=======");
            System.out.println("1. Search by name/type/price range ");
            System.out.println("2. See product description  ");
            System.out.println("3. Shopping");
            System.out.println("0. Exist");
            int ch= CheckInput.intInput("Enter your choice: ");
            switch (ch){
                case 1:
                    searchMenu();
                    break;
                case 2:
                    ViewDetail();
                    break;
                case 3:
                    Shopping();
                    break;
                case 0:
                    System.out.println("Thank you for shopping!");
                    return;
                default:
                    System.out.println("Your choice isn't valid. Please try again!!");
            }
        }
    }
    private void ShowView(List<Product> list) {
        if (list.isEmpty()) {
            System.out.println("No product found!");
            return;
        }

        System.out.printf("%-3s | %-15s | %-10s | %-8s | %-12s | %-12s%n",
                "ID", "Name", "SellPrice", "Quantity", "Manufacturer", "ExpiryDate");
        for (Product p : list) {
            System.out.printf("%-3s | %-15s | %-10.2f | %-8d | %-12s | %-12s%n",
                    p.getId(), p.getName(), p.getSellPrice(), p.getQuantity(),
                    p.getManufacturer(), p.getExpiredDate());
        }
    }
    private void searchMenu(){
        while (true){
            System.out.println("1. Search by name");
            System.out.println("2. Search by type");
            System.out.println("3. Search by price range");
            System.out.println("0. Exit");
            int ch= CheckInput.intInput("Enter your choice: ");
            switch (ch){
                case 1:
                    String name=CheckInput.stringInput("Enter product name: ");
                    List<Product> res= productService.searchByName(name);
                    ShowView(res);
                    break;
                case 2:
                    String type= CheckInput.stringInput("Enter product type: ");
                    List<Product> cate= productService.searchByType(type);
                    ShowView(cate);
                    break;
                case 3:
                    double min=CheckInput.doubleInput("Enter min price: ");
                    double max= CheckInput.doubleInput("Enter max price: ");
                    List<Product> avg= productService.searchByRange(min,max);
                    ShowView(avg);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Your choice isn't valid. Please try again!!");
            }
        }
    }
    private void ViewDetail(){
        String name= CheckInput.stringInput("Enter product name: ");
        List<Product> res= productService.searchByName(name);
        if(res.isEmpty()){
            System.out.println("No product found!!");
        }
        else{
            System.out.printf("%-3s | %-15s | %-10s | %-8s | %-12s | %-12s%n",
                    "ID", "Name", "SellPrice", "Quantity", "Manufacturer", "ExpiryDate");
            for (Product p : res) {
                System.out.printf("%-3s | %-15s | %-10.2f | %-8d | %-12s | %-12s%n",
                        p.getId(), p.getName(), p.getSellPrice(), p.getQuantity(),
                        p.getManufacturer(), p.getExpiredDate());
            }
        }
    }
    private void Shopping() {
        String type ;
        List<Product> res ;
        int typeCount=0;
        while (true){
            type = CheckInput.stringInput("Enter product type: ");
            res = productService.searchByType(type);
            if(!res.isEmpty()){
                ShowView(res);
                break;
            }
            else{
                System.out.println("Product not found !!");
                typeCount++;
            }
            if(typeCount>=3){
                System.out.println("Too many wrong attempts. Exiting shopping...");
                return;
            }
        }
        Product selectedProduct;
        int count=0;
        while (true) {
            String name = CheckInput.stringInput("Enter product name: ");
            selectedProduct = res.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
            if (selectedProduct != null) {
                break;
            }else{
                System.out.println("Product not found!");
                count++;
            }
            if(count>=3){
                System.out.println("Too many wrong attempts. Exiting shopping...");
                return;
            }

        }
        int qty;
        while (true) {
            qty = CheckInput.intInput("Enter quantity: ");
            if (qty <= selectedProduct.getQuantity()) break;
            System.out.println("Not enough stock! Please enter a smaller quantity.");
            break;
        }
        double totalAmount = qty * selectedProduct.getSellPrice();
        boolean ok = productService.buyProduct(selectedProduct.getId(), qty);

        if (ok) {
            System.out.println("Purchase successful.\nPayment amount: " + totalAmount);
        } else {
            System.out.println("Purchase failed!");
        }
    }
}
