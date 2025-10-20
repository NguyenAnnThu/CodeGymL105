package ss6_Extend.service;

public class Cylinder_circle extends circle_Cylinder{

    private double height;

    public Cylinder_circle(double radius, String color,double height) {
        super(radius, color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return getarea()*height;
    }
    @Override
    public String toString(){
        return "Cylinder: \n radius: "+getRadius()+"\n color: "+getColor()+"\n height: "+height+"\n Volume: "+ Math.round(getVolume() * 100) / 100.0;
    }
}
