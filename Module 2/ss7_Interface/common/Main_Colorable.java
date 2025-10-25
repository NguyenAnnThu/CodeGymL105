package ss7_Interface.common;

import ss7_Interface.entity.Square;
import ss7_Interface.service.Colorable;

public class Main_Colorable {
    public static void main(String[] args) {
        Colorable[] square=new Colorable[3];
        square[0]=new Square(2,"blue",true);
        square[1]=new Square(2.4,"Red",false);
        square[2]=new Square(1.2,"Yellow",true);

        System.out.println("Colorable: \n");
        for(Colorable Square:square){
            System.out.println(Square);
            Square.howToColor();
            System.out.println();

        }
    }
}
