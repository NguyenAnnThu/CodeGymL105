package OOP_ss4.Controller;
import OOP_ss4.Service.circle_OOP;
public class main_testCircle {
    public static void main(String[] args) {
        circle_OOP circle1=new circle_OOP();
        circle_OOP circle2=new circle_OOP(3);
        System.out.println("Circle 1: \n radius= "+ circle1.getRadius()+"\n Area: "+ circle1.getArea());
        System.out.println("Circle 2: \n radius= "+ circle2.getRadius()+"\n Area: "+ circle2.getArea());
    }
}
