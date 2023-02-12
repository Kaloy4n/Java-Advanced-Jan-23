package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputDimensions = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(inputDimensions[0]);
        int firstCols = Integer.parseInt(inputDimensions[1]);

        int[][] firstMatrix = new int[firstRows][firstCols];

        //reading 1st matrix
        for (int row = 0; row < firstMatrix.length; row++) {
            String[] rowNumbers = scanner.nextLine().split("\\s+");

            for (int col = 0; col < firstCols; col++) {
                firstMatrix[row][col] = Integer.parseInt(rowNumbers[col]);
            }
        }

        //reading 2nd matrix
        inputDimensions = scanner.nextLine().split("\\s+");
        int secondRows = Integer.parseInt(inputDimensions[0]);
        int secondCols = Integer.parseInt(inputDimensions[1]);

        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int row = 0; row < secondRows; row++) {
            String[] rowNumbers = scanner.nextLine().split("\\s+");

            for (int col = 0; col < secondCols; col++) {
                secondMatrix[row][col] = Integer.parseInt(rowNumbers[col]);
            }
        }

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
}

