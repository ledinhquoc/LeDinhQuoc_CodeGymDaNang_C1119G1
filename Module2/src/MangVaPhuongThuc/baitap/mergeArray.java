package MangVaPhuongThuc.baitap;

import java.util.Arrays;
import java.util.Scanner;

public class mergeArray {
    public static void main(String[] args) {
        String a[] = new String[5];
        String b[] = new String[5];
        String []ab = new String[a.length + b.length];
        int i, j, d, s = 0;
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("enter value of first array:");

        for ( i = 0; i < a.length; i++) {
            a[i] = input.next();
            for ( d = i; d < a.length; d++) {
                ab[d] = a[i];
            }
        }
        System.out.println("enter value of second array:");
        for ( j = 0; j < b.length; j++) {
            b[j] = input.next();
            for ( d = a.length + j; d < ab.length; d++) {
                ab[d] = b[j];
            }
        }
        System.out.println();
        System.out.println("the new array is: ");
        for (s = 0; s < ab.length; s++) {
            System.out.println(ab[s] + " ");
        }
    }
}

