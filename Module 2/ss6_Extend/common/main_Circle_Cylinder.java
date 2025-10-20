package ss6_Extend.common;

import ss6_Extend.service.Cylinder_circle;
import ss6_Extend.service.circle_Cylinder;

public class main_Circle_Cylinder {
    public static void main(String[] args) {
        circle_Cylinder circle=new circle_Cylinder(5,"red");
        System.out.println(circle.toString());

        Cylinder_circle cylinder=new Cylinder_circle(10,"blue",6);
        System.out.println(cylinder.toString());
    }
}
