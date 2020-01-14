package AdvancedObjectOrientedDesign.thuchanh.Comparator;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle(){
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius,String color,boolean filled){
        super(color,false);
        this.radius = radius;
    }
    public double getRadius(){
        return  radius;
    }
    public void setRadius(){
        this.radius = radius;
    }
    public double getArea(){
        return  2*radius*radius*Math.PI;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle" +
                "radius=" + getRadius() + super.toString()
                ;
    }

    @Override
    public void reSize(double percent) {
        System.out.println((this.getArea() * percent) + this.getArea() );
    }
}
