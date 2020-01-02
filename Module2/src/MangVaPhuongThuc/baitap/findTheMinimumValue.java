package MangVaPhuongThuc.baitap;

import java.util.Scanner;

public class findTheMinimumValue {

        public int min(int [] array) {
            int min = array[0];

            for(int i=0; i<array.length; i++ ) {
                if(array[i]<min) {
                    min = array[i];
                }
            }
            return min;
        }
        public static void main(String args[]) {
            Scanner input = new Scanner(System.in);
            System.out.println("enter your number");
            int array[] = new int[5];
            for (int i = 0; i < array.length; i++) {
                array[i] = input.nextInt();
            }
            findTheMinimumValue m = new findTheMinimumValue();
            System.out.println("Minimum value in the array is:" + m.min(array));

        }
}
