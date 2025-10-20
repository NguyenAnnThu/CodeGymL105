package ss6_Extend.common;

import ss6_Extend.service.Triangle;

import java.util.Scanner;

public class Main_Triangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Side 1: ");
        double side1=sc.nextDouble();
        System.out.print("Side 2: ");
        double side2=sc.nextDouble();
        System.out.print("Side 3: ");
        double side3=sc.nextDouble();
        sc.nextLine();

        System.out.print("Color: ");
        String color=sc.nextLine();

        System.out.println("Is the triangle colored?");
        boolean filled=sc.nextBoolean();
        Triangle triangle=new Triangle(side1,side2,side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        System.out.println("\n Triangle Information: ");
        System.out.println(triangle);
    }
}
