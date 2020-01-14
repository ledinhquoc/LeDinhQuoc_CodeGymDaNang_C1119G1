package KeThuaTrongJava.baitap;

public class MovablePoint extends Point {
    private float xSpeed =0.0f;
    private float ySpeed =0.0f;

    public MovablePoint(float x,float y,float xSpeed,float ySpeed){
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public  MovablePoint(){

    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        super.setX(xSpeed);
        super.setY(ySpeed);
    }
    public float[] getSpeed(){
            float arr[] = new float[2];
            return arr;
    }
    public MovablePoint move(){
        this.setX(this.getX()+this.getxSpeed());
        this.setY(this.getY()+this.getySpeed());
        return this;

    }

    @Override
    public String toString() {
        return "MovablePoint{" + "x="+ super.getX()+", y=" + super.getY()+
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}
