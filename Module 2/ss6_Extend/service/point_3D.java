package ss6_Extend.service;

public class point_3D extends point_2D{
    private float z=0.0f;
    public point_3D(float x,float y,float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
       setXY(x,y);
        this.z=z;

    }
    public float[] getXYZ(){
        return new float[]{getX(),getY(),z};
    }
    @Override
    public String toString(){
        return ("("+getX()+","+getY()+","+z+")");
    }

}
