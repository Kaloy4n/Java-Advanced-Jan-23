package TwoDimensionalArrays.Lab;

import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Alternatively, we can read the rows and columns from a single line using:
        // String[] inputDimensions = scanner.nextLine().split("\\s+");
        // int rows = Integer.parseInt(inputDimensions[0]);
        // int cols = Integer.parseInt(inputDimensions[1]);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        // Fill in matrix
        fillMatrix(matrix, scanner);

        /*
        for (int row = 0; row < rows; row++) {
            String[] columns = scanner.nextLine().split(" ");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(columns[col]);
            }
        }*/

        int numberToFind = scanner.nextInt();

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == numberToFind) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}

