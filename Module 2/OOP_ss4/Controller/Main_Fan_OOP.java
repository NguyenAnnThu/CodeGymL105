package OOP_ss4.Controller;

import OOP_ss4.Service.Fan_OOP;

import java.nio.Buffer;
import java.util.Scanner;

public class Main_Fan_OOP {
    public static void main(String[] args) {
        Fan_OOP fan1=new Fan_OOP();
        fan1.setSpeed(Fan_OOP.fast);
        fan1.setRadius(5.6);
        fan1.setColor("red");
        fan1.setOn(true);

        Fan_OOP fan2=new Fan_OOP();
        fan2.setSpeed(Fan_OOP.Slow);
        fan2.setRadius(10);
        fan2.setColor("yellow");
        fan2.setOn(false);

        System.out.println("Fan 1: ");
        System.out.println(fan1.toString());
        System.out.println("\nFan 2: ");
        System.out.println(fan2.toString());

    }
}
