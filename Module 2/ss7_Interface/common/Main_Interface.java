package ss7_Interface.common;

import ss7_Interface.entity.Circle;
import ss7_Interface.entity.Rectangle;
import ss7_Interface.entity.Shape;
import ss7_Interface.entity.Square;
import ss7_Interface.service.ResizeableInterface;

public class Main_Interface {
    public static void main(String[] args) {
        ResizeableInterface[] shapes= new ResizeableInterface[3];
        shapes[0]=new Circle(5);
        shapes[1]= new Rectangle(6,7);
        shapes[2]= new Square(9);

        System.out.println(" Original size: \n");
        for(ResizeableInterface Shape: shapes){
            System.out.println(Shape);
            System.out.println();
        }
        System.out.println(" After resize: \n");
        for(ResizeableInterface shape: shapes){
            shape.resize(10);
            System.out.println(shape);
            System.out.println();
        }

    }
}
