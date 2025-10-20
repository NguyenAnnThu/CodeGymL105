package ss6_Extend.service;

public class circle_Cylinder {
    private double radius;
    private static final double pi=Math.PI;
    private String color;
    public circle_Cylinder(double radius,String color){
        this.radius=radius;
        this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getarea(){
        return pi*radius*radius;
    }
    @Override
    public String toString() {
        return "Circle:\n radius: "+ radius+"\n color: "+color+"\n area: "+ Math.round(getarea()* 100) / 100.0;
    }
}
