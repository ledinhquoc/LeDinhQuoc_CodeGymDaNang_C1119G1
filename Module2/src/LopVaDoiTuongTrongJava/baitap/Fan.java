package LopVaDoiTuongTrongJava.baitap;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    public int speed = SLOW;
    public boolean on = false;
    public double radius = 5;
    public String color = new String("blue");

    boolean fanOn() {
        on = true;
        return on;
    }

    boolean fanOff() {
        on = false;
        return on;
    }

    String setSpeed(String speed) {
        if (speed == "SLOW") {
            speed = String.valueOf(SLOW);
        } else if (speed == "MEDIUM") {
            speed = String.valueOf(MEDIUM);
        } else if (speed == "FAST") {
            speed = String.valueOf(FAST);
        } else {
            speed = "Please enter 'SLOW','MEDIUM'or 'FAST' to change the speed of the fan";
        }
        return speed;
    }

    double setRadius(double rad) {
        rad = radius;
        return rad;
    }

    String setColor(String colorType) {
        return colorType;
    }

    public String toString() {
        return ("Speed:" + speed + "\nRadius:" + radius + "\nColor: " + "\nOn: " + on);
    }
}

 class testFan{
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setColor("green");
        fan1.setSpeed("FAST");
        fan1.setRadius(3.5);
        fan1.fanOff();
        System.out.println(fan1.toString());
    }
}
