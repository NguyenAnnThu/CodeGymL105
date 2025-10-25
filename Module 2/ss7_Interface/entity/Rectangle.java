package ss7_Interface.entity;

import ss7_Interface.service.ResizeableInterface;

public class Rectangle extends Shape implements ResizeableInterface {
    private double width;
    private double height;
    public Rectangle(double width,double height){
        this.height=height;
        this.width=width;
    }
    public Rectangle(double width,double height,String color, boolean filled){
        super(color,filled);
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea(){
        return width*height;
    }
    @Override
    public void resize(double percent) {
        this.height *=(1+percent/100);
        this.width *=(1+percent/100);
    }
    @Override
    public String toString(){
        return "Rectangle:"
                +   "\n width: " + width
                +   "\n height: " + height
                +   "\n color: " + getColor()
                +   "\n area: " + Math.round(getArea() * 100) / 100.0
                +   "\n Subclass of "+ super.toString();
    }
}
