package TwoDimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[n][n];

        switch (pattern) {
            case "A" ->
                // pattern A -> by columns
                    fillMatrixPatternA(matrix);
            case "B" ->
                // pattern B
                // if column index is even then rows are filled from top to bottom element.
                // if column index is odd then rows are filled from bottom to top element.
                    fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNumber++;
            }
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            if ((col) % 2 == 0) {
                for (int row = 0; row <= matrix.length - 1; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0 ; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rowElem : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(rowElem[col] + " ");
            }
            System.out.println();
        }
    }
}
