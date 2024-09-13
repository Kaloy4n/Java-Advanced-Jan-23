package TwoDimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading 1st matrix
        String[] inputDimensions = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(inputDimensions[0]);
        int firstCols = Integer.parseInt(inputDimensions[1]);
        // Alternatively:
        // int firstRows = scanner.nextInt();
        // int firstCols = scanner.nextInt();
        int[][] firstMatrix = new int[firstRows][firstCols];

        fillIntMatrix(firstMatrix, scanner);

        // Reading 2nd matrix
        int secondRows = scanner.nextInt();
        int secondCols = scanner.nextInt();

        // Alternatively:
        // inputDimensions = scanner.nextLine().split("\\s+");

        int[][] secondMatrix = new int[secondRows][secondCols];
        fillIntMatrix(secondMatrix, scanner);

        /*  Alternative way of filling in the matrix


            for (int row = 0; row < secondRows; row++) {
            String[] rowNumbers = scanner.nextLine().split("\\s+");

            for (int col = 0; col < secondCols; col++) {
                secondMatrix[row][col] = Integer.parseInt(rowNumbers[col]);
            }
        }
        */

        if (firstRows != secondRows || firstCols != secondCols) {
            System.out.println("not equal");
            return;
        }

        boolean areEqual = true;
        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < firstCols; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    areEqual = false;
                    break;
                }
            }
            if(!areEqual) {
                break;
            }
        }

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static void fillIntMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}

