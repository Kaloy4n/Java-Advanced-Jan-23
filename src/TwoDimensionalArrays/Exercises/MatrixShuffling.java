package TwoDimensionalArrays.Exercises;

import java.util.Scanner;

public class MatrixShuffling {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String dimensionsInput = scanner.nextLine();
        int rows = Integer.parseInt(dimensionsInput.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensionsInput.split("\\s+")[1]);
        String [][] matrix = new String[rows][cols];
        fillMatrix(matrix);

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            if(validateCommand(command, rows, cols)) {
                String[] commandParts = command.split("\\s+");

                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean validateCommand (String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");

        if(commandParts.length != 5) {
            return false;
        }

        if(!commandParts[0].equals("swap")) {
            return false;
        }

        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        return row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows && col1 >= 0 && col1 < cols && col2 >= 0 && col2 < cols;
    }

    static void printMatrix(String[][] matrix) {
        for (String[] rowElem : matrix) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(rowElem[col] + " ");
            }
            System.out.println();
        }
    }
}

