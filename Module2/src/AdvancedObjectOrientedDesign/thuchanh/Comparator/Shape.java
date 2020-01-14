package AdvancedObjectOrientedDesign.thuchanh.Comparator;

import AdvancedObjectOrientedDesign.baitap.Resizable;

public class Shape implements Resizable {
    private String color = "Green";
    private boolean filled = true;

    public Shape(){
    }
    public Shape(String color, boolean filled, double Resizeable){
        this.color = color;
        this.filled = filled;
    }

    public Shape(String color, boolean b) {
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    @Override
    public void reSize(double percent) {

    }
}
