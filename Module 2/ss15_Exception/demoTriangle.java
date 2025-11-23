package ss15_Exception;

import java.util.Scanner;

public class demoTriangle {
    private double a,b,c;
    public demoTriangle(double a, double b, double c) throws IllegalTriangleException{
            if(a<=0 || b<=0 || c<=0){
                throw new IllegalTriangleException("The sides must be positive!");
            }
            if(a+b<c || a+c<b|| b+c<a){
                throw new IllegalTriangleException("The sum of two sides must be greater than the remaining side.");
            }
            this.a=a;
            this.b=b;
            this.c=c;
    }
    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while (true){
            try{
                System.out.println("Enter side a: ");
                double a= sc.nextDouble();
                System.out.println("Enter side b: ");
                double b= sc.nextDouble();
                System.out.println("Enter side c: ");
                double c=sc.nextDouble();
                demoTriangle triangle=new demoTriangle(a,b,c);
                System.out.println("Triangle is valid! "+ triangle);
                break;
            }catch (IllegalTriangleException e){
                System.out.println("Error: "+ e.getMessage());
            }catch (Exception e){
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}
