package MangVaPhuongThuc.baitap;

import java.io.*;
import java.lang.*;
import java.util.*;
public class ThemPhanTuVaoMang {

        public static int[] addX(int n, int arr[], int x,int pos)
        {
            int i;

            int newarr[] = new int[n + 1];


            for (i = 0; i < n + 1; i++)
                if (i < pos -1 )
                newarr[i] = arr[i];
                else if (i == pos -1)
                newarr[i]= x;
                else
                    newarr[i] = arr[i-1];
            return newarr;
        }
        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            int pos;
            int x;
            int n = 10;
            int i;
            int arr[]
                    = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            System.out.println("enter position: ");
            pos = input.nextInt();
            System.out.println("Initial Array:\n"
                    + Arrays.toString(arr));
            System.out.println("enter X :");
            x = input.nextInt();
            arr = addX(n, arr, x,pos);
            System.out.println("\nArray with " + x
                    + " added:\n"
                    + Arrays.toString(arr));
        }
    }