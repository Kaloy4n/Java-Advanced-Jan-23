package TwoDimensionalArrays.Lab;

import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        // You will be given the rows of a matrix. Then the matrix itself.
        // Inside this matrix, there are mistaken values that need to be replaced.
        // You will receive the wrong value at the last line.
        // Those values should be replaced with the sum of the nearest elements in the four directions, up, down, left, and right, but only if they are valid values.
        // In the end, you have to print the fixed measurements.

        Scanner scanner = new Scanner(System.in);
        int rowsOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsOfMatrix][];

        fillMatrix(matrix, scanner);

        int wrongRow = scanner.nextInt();
        int wrongCol = scanner.nextInt();

        int mistakenValue = matrix[wrongRow][wrongCol];

        // Fix the mistaken values in the matrix
        fixMatrix(matrix, mistakenValue);

        // Print the corrected matrix
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rowOfIntegers : matrix) {
            for (int cellInRow : rowOfIntegers) {
                System.out.print(cellInRow + " ");
            }
            System.out.println();
        }
    }

    private static int sumOfValidNeighbours(int[][] matrix, int wrongRow, int wrongCol, int mistakenValue) {
        int sumOfNeighbouringElements = 0;

        //Check up
        if (wrongRow > 0 && matrix[wrongRow - 1][wrongCol] != mistakenValue) {
            sumOfNeighbouringElements += matrix[wrongRow - 1][wrongCol];
        }
        //Check down
        if (wrongRow < matrix.length - 1 && matrix[wrongRow + 1][wrongCol] != mistakenValue) {
            sumOfNeighbouringElements += matrix[wrongRow + 1][wrongCol];
        }
        //Check left
        if (wrongCol > 0 && matrix[wrongRow][wrongCol - 1] != mistakenValue) {
            sumOfNeighbouringElements += matrix[wrongRow][wrongCol - 1];
        }
        // Check right
        if (wrongCol < matrix[wrongRow].length - 1 && matrix[wrongRow][wrongCol + 1] != mistakenValue) {
            sumOfNeighbouringElements += matrix[wrongRow][wrongCol + 1];
        }
        return sumOfNeighbouringElements;
    }


    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            matrix[row] = new int[currentRow.length];
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(currentRow[col]);
            }
        }
    }

    // Method to fix the matrix by replacing mistaken values with the sum of valid adjacent elements
    private static void fixMatrix(int[][] matrix, int mistakenValue) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a copy of the matrix to store corrected values
        int[][] correctedMatrix = new int[rows][cols];

        // Iterate over each element in the matrix
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If the current element is the mistaken value, replace its value with its corrected one
                if (matrix[row][col] == mistakenValue) {
                    correctedMatrix[row][col] = sumOfValidNeighbours(matrix, row, col, mistakenValue);
                } else {
                    // Otherwise, keep the original value
                    correctedMatrix[row][col] = matrix[row][col];
                }
            }
        }

        // Update the original matrix with corrected values
        for (int row = 0; row < rows; row++) {
            System.arraycopy(correctedMatrix[row], 0, matrix[row], 0, cols);
        }
    }
}
