package casestudy.controller;

import casestudy.common.CheckInput;
import casestudy.entity.Product;
import casestudy.service.CategoryService;
import casestudy.service.ProductService;
import  casestudy.entity.Category;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellerController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Scanner sc;

    public SellerController(ProductService productService, CategoryService categoryService, Scanner sc) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.sc = sc;
    }

    public void menu() {
        while (true) {
            System.out.println("======Seller Menu======");
            System.out.println("1. View product list");
            System.out.println("2. Create new product");
            System.out.println("3. Update product");
            System.out.println("4. Searching");
            System.out.println("5. View expired product list");
            System.out.println("6. Delete product.");
            System.out.println("0. Exit");
            int choice = CheckInput.intInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    searchMenu();
                    break;
                case 5:
                    expiredMenu();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 0:
                    System.out.println("Exit Seller Menu!");
                    return;
                default:
                    System.out.println("Your choice isn't valid");
            }
        }
    }

    private void showAll() {
        List<Product> all = productService.findAll();
        System.out.println("======Product List=====");
        if (all.isEmpty()) {
            System.out.println("There are no products in stock");
            System.out.println();
            return;
        }
        System.out.printf(
                "%-5s | %-15s | %-12s | %-10s | %-15s | %-15s | %-15s | %-12s | %-12s%n",
                "ID", "Name", "Type", "Quantity", "ImportPrice", "SellPrice",
                "Manufacturer", "ExpiryDate", "ImportDate"
        );
        for (Product p : all) {
            System.out.printf(
                    "%-5s | %-15s | %-12s | %-10d | %-11.2f VND | %-11.2f VND | %-15s | %-12s | %-12s%n",
                    p.getId(), p.getName(), p.getType(), p.getQuantity(),
                    p.getImportPrice(), p.getSellPrice(), p.getManufacturer(),
                    p.getExpiredDate(), p.getImportDate()
            );
        }

    }

    private void addProduct() {
        System.out.println("======Add New Product======");
        String id ;
        while (true) {
            id = CheckInput.stringInput("Enter ID: ");
            if (productService.findById(id) == null) break;
            System.out.println("ID already exists! Please enter a different ID.");
        }
        String name = CheckInput.stringInput("Enter product name: ");

        for (Product p : productService.findAll()) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println("This product name already exists: \n " + p);
                boolean sameManu = CheckInput.yesNo("Does it have the same manufacturer?");
                if (sameManu) {
                    System.out.println("Cannot add this product.");
                    return;
                } else {
                    System.out.println("Continue add new product.");
                    break;
                }
            }
        }
        String manu = CheckInput.stringInput("Enter manufacturer: ");
        for (Product p: productService.findAll()){
            if (p.getName().equalsIgnoreCase(name) && p.getManufacturer().equalsIgnoreCase(manu)) {
                System.out.println("Cannot add this product.");
                return;
            }
            else {
                break;
            }
        }
        String type = CheckInput.stringInput("Enter product type:");
        int qty = CheckInput.intInput("Enter quantity: ");
        double imp ;
        double sell ;
        int count=0;
        while(true){
            imp = CheckInput.doubleInput("Enter import price: ");
            sell = CheckInput.doubleInput("Enter sell price: ");
            if(imp<sell){
                break;
            }else{
                System.out.println("Please try again!");
                count++;
            }
            if(count>3){
                System.out.println("Too many wrong attempts. Exiting shopping..");
                return;
            }

        }
        LocalDate importDate = CheckInput.dateInput("Enter import date: ");
        LocalDate expiredDate = LocalDate.parse(CheckInput.InputExpiredDate("Enter expiry: ", importDate.toString()));

        Category existingCategory = categoryService.findByName(type);
        if (existingCategory==null) {
            categoryService.save(new Category(id, type));
        }

        Product p = new Product(id, name, type, manu, qty, imp, sell, expiredDate, importDate);

        boolean ok = productService.addProduct(p);
        System.out.println(ok ? "Succesful" : "More failed products");
    }

    private void updateProduct() {
        System.out.println("======Update Product======");
        String id;
        Product p;
        while (true) {
            id = CheckInput.stringInput("Enter the ID to Update: ");
            p = productService.findById(id);
            if (p != null) break;
            System.out.println("Product ID not found. Please enter again.");
        }

        int opt;
        while (true) {
            System.out.println("1. Update quantity");
            System.out.println("2. Update import price");
            System.out.println("3. Update sell price");
            opt = CheckInput.intInput("Your choice: ");
            if (opt >= 1 && opt <= 3) break;
            System.out.println("Invalid choice. Please choose 1-3.");
        }

        boolean ok = productService.updateProduct(id, opt);
        System.out.println(ok ? "Successful" : "Update failed products");
    }

    private void deleteProduct() {
        System.out.println("======Delete Product======");
        String id;
        while (true) {
            id = CheckInput.stringInput("Enter product ID to delete: ");
            final String finalId = id;

            boolean existsInStock = productService.findById(id) != null;
            boolean existsInExpired = productService.getExpiredList().stream()
                    .anyMatch(p -> p.getId().equalsIgnoreCase(finalId));

            if (existsInStock || existsInExpired) break; // id hợp lệ
            System.out.println("Product ID not found. Please enter again.");
        }

        boolean confirm = CheckInput.yesNo("Are you sure to delete this product?");
        if (confirm) {
            // Xóa cả trong kho và expired
            boolean removedFromStock = productService.deleteById(id);  // cần thêm deleteById trong service/repo
            boolean removedFromExpired = productService.deleteExpiredById(id);

            if (removedFromStock || removedFromExpired) {
                System.out.println("Product delete successful");
            } else {
                System.out.println("Failed to delete product.");
            }
        }
    }


    private void searchMenu() {
        System.out.println("======Search Product======");
        int choice;
        while (true) {
            System.out.println("1. Search by product name");
            System.out.println("2. Search by product type");
            choice = CheckInput.intInput("Enter your choice: ");
            if (choice == 1 || choice == 2) break;
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }

        if (choice == 1) {
            String name = CheckInput.stringInput("Enter product name: ");
            List<Product> search = productService.searchByName(name);
            if (search.isEmpty()) System.out.println("No product found.");
            else search.forEach(System.out::println);
        } else {
            String type = CheckInput.stringInput("Enter product type: ");
            List<Product> search = productService.searchByType(type);
            if (search.isEmpty()) System.out.println("No product found.");
            else search.forEach(System.out::println);
        }
    }

    private void expiredMenu() {
        productService.autoExpiredCheck();

        while (true) {
            System.out.println("=======Expired Menu=====");
            List<Product> exp = productService.getExpiredList();
            if (exp.isEmpty()) {
                System.out.println("There are no expired or near-expired products.");
            } else {
                System.out.printf(
                        "%-5s | %-15s | %-12s | %-10s | %-15s | %-15s | %-15s | %-12s | %-12s%n",
                        "ID", "Name", "Type", "Quantity", "ImportPrice", "SellPrice",
                        "Manufacturer", "ExpiryDate", "ImportDate"
                );
                for (Product p : exp) {
                    System.out.printf(
                            "%-5s | %-15s | %-12s | %-10d | %-11.2f VND | %-11.2f VND | %-15s | %-12s | %-12s%n",
                            p.getId(), p.getName(), p.getType(), p.getQuantity(),
                            p.getImportPrice(), p.getSellPrice(), p.getManufacturer(),
                            p.getExpiredDate(), p.getImportDate()
                    );
                }
            }

            System.out.println("1. Remove product from expired list");
            System.out.println("2. Exit");

            int ch;
            while (true) {
                ch = CheckInput.intInput("Enter your choice: ");
                if (ch == 1 || ch == 2) break;
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

            if (ch == 1) {
                if (exp.isEmpty()) {
                    System.out.println("No products to remove.");
                    continue;
                }

                String idToRemove;
                int count=0;
                while (true) {
                    String tempId = CheckInput.stringInput("Enter ID to remove: ");
                    boolean exists = exp.stream().anyMatch(p -> p.getId().equalsIgnoreCase(tempId));
                    if (exists) {
                        idToRemove = tempId;
                        break;
                    }else{
                        System.out.println("ID not found in expired list. Please enter again.");
                        count++;
                    }
                    if(count>3){
                        System.out.println("Too many wrong attempts. Exiting shopping...");
                        return;
                    }

                }

                boolean confirm = CheckInput.yesNo("Are you sure to remove this product?");
                if (confirm) {
                    boolean removed = productService.deleteExpiredById(idToRemove);
                    System.out.println(removed ? "Successful" : "Failed to remove product.");
                }
            } else {
                return;
            }
        }
    }
}