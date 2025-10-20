package ss6_Extend.common;

import ss6_Extend.service.movable_Point;

public class Main_movable {
    public static void main(String[] args) {
        movable_Point mp=new movable_Point(1f,3.5f,6f,7f);
        System.out.println("Before move:\n "+mp);
        mp.move();
        System.out.println("After move:\n "+mp);
    }
}
