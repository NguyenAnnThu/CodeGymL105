package ss7_Interface.entity;

import ss7_Interface.service.Colorable;
import ss7_Interface.service.ResizeableInterface;

public class Square extends Shape implements ResizeableInterface, Colorable {
    private double side;
    public Square(double side){
        this.side=side;
    }
    public Square(double side,String color,boolean filled){
        super(color,filled);
        this.side=side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea(){
        return side*side;
    }
    @Override
    public void resize(double percent) {
        this.side *=(1+percent/100);
    }
    @Override
    public String toString(){
        return "Square:"
                +   "\n side: " + side
                +   "\n color: " + getColor()
                +   "\n area: " + Math.round(getArea() * 100) / 100.0
                +   "\n Subclass of "+ super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println(" Color all four sides");
    }

}
