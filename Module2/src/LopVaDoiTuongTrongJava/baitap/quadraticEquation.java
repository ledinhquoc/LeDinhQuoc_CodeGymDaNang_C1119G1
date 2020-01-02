package LopVaDoiTuongTrongJava.baitap;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class quadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("enter your number a:");
        double a = input.nextDouble();
        System.out.println("enter your number b:");
        double b = input.nextDouble();
        System.out.println("enter your number c:");
        double c = input.nextDouble();

        double result = b * b - 4 * a * c;

        if (result > 0.0) {
            double x1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
            double x2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);
            System.out.println("nghiệm của phương trình là " + x1 + "và" + x2);
        } else if (result == 0.0) {
            double x1 = -b / (2.0 * a);
            System.out.println("nghiệm của phương trình là :" + x1);
        } else {
            System.out.println("phương trình vô nghiệm");
        }
    }
}
