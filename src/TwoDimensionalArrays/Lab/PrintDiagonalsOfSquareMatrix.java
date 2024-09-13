package TwoDimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {

            String[] currentRowAsString = scanner.nextLine().split(" ");
//            int[] currentRow = new int[size]
//            for (int col = 0; col < currentRowAsString.length; col++) {
//                currentRow[col] = Integer.parseInt(currentRowAsString[col];
//            }

            int[] currentRowAsInt = Arrays.stream(currentRowAsString)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = currentRowAsInt;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(row == col) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();

        /*
        for (int row = size - 1, col = 0; col < matrix.length; row--, col++) {
            System.out.print(matrix[row][col] + " ");
        }
        */

        for (int i = matrix.length; i > 0; i--) {
            System.out.print(matrix[i - 1][matrix.length - i] + " ");
        }
    }
}
