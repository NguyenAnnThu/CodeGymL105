package ss11_Stack_Queue.mvc.view;

import mvc.entity.Student;
import ss11_Stack_Queue.mvc.common.CheckInput;
import ss11_Stack_Queue.mvc.controller.ProController;
import ss11_Stack_Queue.mvc.entity.Products;

import java.util.List;
import java.util.Scanner;

public class ProductView {
        private static  ProController controller = new ProController();
        public void View(){
            Scanner sc= new Scanner(System.in);
            while (true){
                System.out.println("===== Quan ly san pham =====");
                System.out.println("1. Hien thi danh sach");
                System.out.println("2. Them moi san pham");
                System.out.println("3. Chinh sua san pham");
                System.out.println("4. Xoa san pham");
                System.out.println("5. Tim kiem theo ten");
                System.out.println("6. Sap xep tang dan theo gia");
                System.out.println("7. Sap xep giam dan theo gia");
                System.out.println("0. Thoat");
                int choice= CheckInput.inputInt("Nhap lua chon cua ban: ");
                System.out.println();
                switch (choice){
                    case 1:
                        ShowListPro();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        searchByName();
                        break;
                    case 6:
                        sortAsc();
                        break;
                    case 7:
                        sortDec();
                        break;
                    case 0:
                        System.out.println("Good bye!!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui long nhap lai");
                }
            }
        }

    public void ShowListPro() {
        List<Products> products =controller.findAll();
        if(products.isEmpty()){
            System.out.println("Danh sach trong");
            System.out.println();
        }
        else {
            products.forEach(System.out::println);
        }
    }
    public void addProduct(){
        Products p= CheckInput.input(true);
        boolean success=controller.add(p);
        if(success){
            System.out.println("Da them moi san pham");
        }
        else {
            System.out.println("San pham da ton tai");
        }
    }
    public void updateProduct(){
        int id=CheckInput.inputInt("Nhap ID:");
        Products pt=controller.findById(id);
        if(pt==null){
            System.out.println("Khong tim thay san pham");
            return;
        }
        System.out.println("1. Chinh sua gia san pham.");
        System.out.println("2. Chinh sua so luong san pham.");
        int choice= mvc.common.CheckInput.inputInt("Vui long chon : ");
        switch (choice){
            case 1:
                float newPrice=ss11_Stack_Queue.mvc.common.CheckInput.inputFloat("Nhap gia moi");
                pt.setPrice(newPrice);
                break;
            case 2:
                int newQuantity= ss11_Stack_Queue.mvc.common.CheckInput.inputInt("Nhap so luong moi: ");
                pt.setQuantity(newQuantity);
                break;
            default:
                System.out.println("Vui long chon lai!");
                return;
        }
        controller.update(pt);
        System.out.println("Update successful!");
    }
    public  void deleteProduct(){
            int id=CheckInput.inputInt("Nhap id:");
            boolean success = controller.delete(id);
            if(success)
                System.out.println("Da xoa san pham");
            else
                System.out.println("Khong tim thay san pham");
    }
    public void searchByName(){
            String name=CheckInput.inputString("Nhap ten san pham");
            List<Products> list=controller.searchByName(name);
            if(list.isEmpty()){
                System.out.println("San pham khong ton tai");
            }
            else{
                System.out.println("Thong tin san pham");
                list.forEach(System.out::println);
            }
    }
    public void sortAsc(){
            controller.sortAsc();
            System.out.println("Danh sach sau khi tang dan");
            ShowListPro();
    }
    public void sortDec(){
            controller.sortDec();
            System.out.println("Danh sach sau khi giam dan");
            ShowListPro();
    }

}


