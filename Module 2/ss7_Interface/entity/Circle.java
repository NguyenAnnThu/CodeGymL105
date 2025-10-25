package ss7_Interface.entity;

import ss7_Interface.service.ResizeableInterface;

public class Circle extends Shape implements ResizeableInterface {
    private double radius;
    public Circle(double radius){
        this.radius=1.0;
    }
    public Circle(double radius, String color,boolean filled){
        super(color,filled);
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }

    @Override
    public void resize(double percent) {
        this.radius*=(1+percent/100);
    }
    @Override
    public String toString() {
        return "Circle:"
                +   "\n radius: "+ radius
                +   "\n area: " + Math.round(getArea()* 100) / 100.0
                +   "\n color: " + getColor()
                +   "\n Subclass of "+ super.toString();
    }
}
