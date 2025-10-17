package OOP_ss4.Controller;

import OOP_ss4.Service.QuadraticEquation;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_OOp {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double a=0,b=0,c=0;
        while(true){
            try{
                System.out.println("Enter number a: ");
                a=sc.nextDouble();
                System.out.println("Enter number b: ");
                b=sc.nextDouble();
                System.out.println("Enter number c: ");
                c=sc.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("Please enter a number");
                sc.next();
            }
        }
        QuadraticEquation equation=new QuadraticEquation(a,b,c);
        double delta=equation.getDiscriminant();
        if(delta>=0){
            System.out.println("X1: "+ equation.getRoot1() +"\n X2: "+ equation.getRoot2());
        }
        else if(delta ==0){
            System.out.println("The equation has one root: "+ equation.getRoot1());
        }
        else{
            System.out.println("The equation has no real roots. ");
        }
    }
}
