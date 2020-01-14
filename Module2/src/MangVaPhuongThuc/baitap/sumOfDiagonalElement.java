package MangVaPhuongThuc.baitap;

import java.util.Scanner;

public class sumOfDiagonalElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int i,j,row,col,sum = 0;
        System.out.println("Enter the number of row:");
        row = input.nextInt();
        System.out.println("ENter your number of col");
        col = input.nextInt();

        int[][] mat = new int[row][col];

        System.out.println("Enter the element of matrix");
        for (i = 0; i < row; i++){
            for (j = 0; j< col; j++){
                mat[i][j] = input.nextInt();
            }
        }
        System.out.println("The element of the matrix");
        for (i = 0 ; i < row; i++){
            for (j = 0; j < col; j++){
                System.out.println(mat[i][j] + "\t");
            }
            System.out.println(" ");
        }
        for (i = 0 ; i < row; i++){
            for (j = 0 ; j < col; j++){
                if (i == j){
                    sum += mat[i][j];
                }
            }
        }
        System.out.println("SUM OF DIAGONAL ELEMENT OF MATRIX  = : " + sum);
    }
}
