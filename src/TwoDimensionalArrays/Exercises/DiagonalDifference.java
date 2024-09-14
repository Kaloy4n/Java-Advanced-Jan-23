package TwoDimensionalArrays.Exercises;

import java.util.Scanner;

public class DiagonalDifference {
     static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //n is number of rows and columns
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][n];

        //1. Fill in the matrix
        fillMatrix(matrix);

        //2. sum of the numbers on the primary diagonal
        int sumPrimary = getSumElementsOnPrimaryDiagonal(matrix);
        //3. sum of the numbers on the secondary diagonal
        int sumSecondary = getSumElementsOnSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimary - sumSecondary));
    }

    private static int getSumElementsOnPrimaryDiagonal(int [][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(row == col) {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnSecondaryDiagonal(int [][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                if (row == matrix.length - 1 - col) {
                    //row == matrix.length - 1  - row  for square matrix
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    public static void fillMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
