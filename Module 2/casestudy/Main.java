package casestudy;

import casestudy.controller.CustomerController;
import casestudy.controller.SellerController;
import casestudy.repository.CategoryRepository;
import casestudy.repository.ProductRepository;
import casestudy.service.CategoryService;
import casestudy.service.ProductService;
import casestudy.view.MenuView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        CategoryRepository categoryRepository= new CategoryRepository();
        ProductService productService=new ProductService(productRepository);
        CategoryService categoryService= new CategoryService(categoryRepository);
        SellerController sellerController = new SellerController(productService,categoryService,sc);
        CustomerController customerController=new CustomerController(productService,categoryService,sc);
        MenuView menu=new MenuView(sellerController,customerController);
        productService.autoExpiredCheck();
        menu.showMainView();
        sc.close();
    }
}
