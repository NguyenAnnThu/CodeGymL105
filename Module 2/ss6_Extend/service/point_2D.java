package ss6_Extend.service;

public class point_2D {
    private float x=0.0f;
    private float y=0.0f;
    public point_2D(){

    }
    public point_2D(float x,float y){
        this.x=x;
        this.y=y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    public float[] getXY(){
        return new float[]{x,y};
    }
    public void setXY(float x,float y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString(){
        return ("("+x+","+y+")");
    }
}
