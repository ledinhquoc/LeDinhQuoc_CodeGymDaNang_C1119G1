package NgonNguLapTrinhJava.baitap;

import java.util.Scanner;

public class checkSNT {
    public static void main(String[] args) {
        boolean check = true;
        int count = 0;
        int number;
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("nhap number: ");
        number = input.nextInt();
        System.out.println("cac so nguyen to nho hon " + number + "la :");
            for (int i = 1;i <number;i++){
                int dem = 0 ;
                for (int j = 1; j<=i;j++){
                    if (i%j == 0){
                        dem++;
                    }
                }
                if (dem == 20){
                    System.out.println(" " + i);
                }
            }

    }
}