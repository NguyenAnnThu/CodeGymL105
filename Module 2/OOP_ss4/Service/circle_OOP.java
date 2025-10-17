package OOP_ss4.Service;

public class circle_OOP {
    private double radius=1.0;
    private String color="red";
    private static final double Pi=Math.PI;
    public  circle_OOP(){
    }
    public circle_OOP(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return Pi*radius*radius;
    }
}
