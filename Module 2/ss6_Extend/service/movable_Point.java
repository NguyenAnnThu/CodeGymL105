package ss6_Extend.service;

public class movable_Point extends point_2D {
    private float xspeed=0.0f;
    private float yspeed=0.0f;
    public movable_Point(float xspeed,float yspeed){
        this.xspeed=xspeed;
        this.yspeed=yspeed;
    }
    public movable_Point(float x, float y,float xspeed,float yspeed){
        super(x,y);
        this.yspeed=yspeed;
        this.xspeed=xspeed;
    }
    public movable_Point(){

    }

    public float getXspeed() {
        return xspeed;
    }

    public void setXspeed(float xspeed) {
        this.xspeed = xspeed;
    }

    public float getYspeed() {
        return yspeed;
    }

    public void setYspeed(float yspeed) {
        this.yspeed = yspeed;
    }
    public void setSpeed(float xspeed,float yspeed){
        this.xspeed=xspeed;
        this.yspeed=yspeed;
    }
    public float[] getSpeed(){
        return new float[]{xspeed,yspeed};
    }
    public String toString(){
        return "x: "+ getX() +"\ny: "+getY()+"\nSpeed= ("+xspeed+","+yspeed+")";
    }
    public movable_Point move(){
        setX(getX()+xspeed);
        setY(getY()+yspeed);
        return this;
    }
}
