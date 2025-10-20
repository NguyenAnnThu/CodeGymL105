package ss6_Extend.common;

import ss6_Extend.service.point_2D;
import ss6_Extend.service.point_3D;

public class main_Point2D_3D {
    public static void main(String[] args) {
        point_2D p2= new point_2D(3.5f,5.5f);
        System.out.println("Point_2D: "+p2.toString());

        point_3D p3= new point_3D(5.3f,2.0f,5f);
        System.out.println("Point_3D: "+p3.toString());

        p3.setXYZ(5,3,5);

        float[] arr=p3.getXYZ();
        System.out.println(" x="+arr[0]+"\n y="+arr[1]+"\n z="+arr[2]);
    }
}
