package AdvancedObjectOrientedDesign.baitap;

import AdvancedObjectOrientedDesign.thuchanh.Comparator.Circle;

import java.util.Random;

public class TestResizeableCircle {
    public static void main(String[] args) {

        Random r = new Random(100);
        Circle circle = new Circle(5.0);
        System.out.println(circle.getArea());
        circle.reSize(r.nextDouble());
    }
}
