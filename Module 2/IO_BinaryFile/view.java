package IO_BinaryFile;

import IO_BinaryFile.ProductFile;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class view {
    private  static  final String File_Path="D:\\CodeGym\\Module2\\Module2\\src\\IO_BinaryFile\\ProductData";
    public static void writetoFile(List<ProductFile> products){
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(File_Path))){
            oos.writeObject(products);
            System.out.println("Ghi file thanh cong");
        }catch (IOException e){
            System.out.println("Loi ghi file :"+ e.getMessage());
        }
    }
    public static List<ProductFile> readFromFile(){
        List<ProductFile> products= new ArrayList<>();
        try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream(File_Path))){
            products= (List<ProductFile>) ois.readObject();
        }catch (FileNotFoundException e){

        }catch (Exception e){
            System.out.println("Loi: "+ e.getMessage());
        }
        return products;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<ProductFile> list= view.readFromFile();
        while(true){
            System.out.println();
            System.out.println("=======MENU=======");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi san pham");
            System.out.println("3. Tim kiem theo ma");
            System.out.println("4. Thoat");
            System.out.println();
            System.out.println("=======Lua chon=======");
            int choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    list.add(inputProduct(sc));
                    view.writetoFile(list);
                    break;
                case 2:
                    System.out.printf("%-5s %-10s %-10s %-15s %-15s%n", "id", "name", "price", "manufacturer", "note");
                    for (ProductFile p : list) {
                        System.out.printf("%-5d %-10s %-10.2f %-15s %-15s%n",
                                p.getId(), p.getName(), p.getPrice(), p.getManufacturer(), p.getNote());
                    }
                    break;
                case 3:
                    System.out.println("Nhap ma :");
                    int id=Integer.parseInt(sc.nextLine());
                    boolean found=false;
                    for(ProductFile p: list){
                        if(p.getId()==id){
                            System.out.println("Tim thay: "+p);
                            found=true;
                        }
                    }
                    if(!found){
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 4:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Vui long nhap laij");
            }
        }
    }

    private static ProductFile inputProduct(Scanner sc) {
        System.out.print("Ma San pham: ");
        int id=Integer.parseInt(sc.nextLine());
        System.out.print("Ten san pham: ");
        String name= sc.nextLine();
        System.out.println("Gia: ");
        double price= Double.parseDouble(sc.nextLine());
        System.out.println("Hang san xuat: ");
        String manu= sc.nextLine();
        System.out.println("Ghi chu: ");
        String note= sc.nextLine();
        return new ProductFile(id,name,price,manu,note);
    }
}
