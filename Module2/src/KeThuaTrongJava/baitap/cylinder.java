package KeThuaTrongJava.baitap;

public class cylinder extends Circle {
    private int height;
    public cylinder(){
    super();
    }
    public cylinder(int height,int Radius,String color){
        super(Radius,color);
            this.height = height;
    }
    public double getVolume(){
        return getArea()*height;
    }
    @Override
    public String toString(){
        return "A cylinder with volume = " + getVolume() + "which is a subclass of" + super.toString();
    }
}
