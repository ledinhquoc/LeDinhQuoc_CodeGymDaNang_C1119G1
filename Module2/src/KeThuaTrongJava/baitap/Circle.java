package KeThuaTrongJava.baitap;

public class Circle {
    private int Radius;
    private String Color;

    public Circle(int Radius, String Color){
        this.Radius = Radius;
        this.Color = Color;
    }

    public Circle() {
    }


    public String getColor(){
        return this.Color;
    }
    public int getRadius(){
        return  this.Radius;
    }
    public double getArea(){
        return Radius*Radius*Math.PI;
    }
    @Override
    public String toString(){
        return "A circle with area = "+getArea()+",which is subclass of" + super.toString();
    }

}
