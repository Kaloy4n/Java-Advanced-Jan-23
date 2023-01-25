package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = matrixReader(rows, cols);
        char[][] secondMatrix = matrixReader(rows, cols);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print('*' + " ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] matrixReader (int rows, int cols){
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] columnData = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = columnData[col].charAt(0);
            }
        }
        return matrix;
    }
}
