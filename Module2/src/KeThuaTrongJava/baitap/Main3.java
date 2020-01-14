package KeThuaTrongJava.baitap;

public class Main3 {
    public static void main(String[] args) {

        MovablePoint movablePoint = new MovablePoint(2,3,4,1);

        System.out.println(movablePoint.toString());
        movablePoint.move();
        System.out.println(movablePoint.toString());



    }
}
