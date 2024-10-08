package TwoDimensionalArrays.Lab;

import java.util.Scanner;

public class MaxSumOf2x2SubMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] table = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] columnData = scanner.nextLine().split(", ");

            for (int col = 0; col < cols; col++) {
                table[row][col] = Integer.parseInt(columnData[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumTopLeftRow = -1;
        int maxSumTopLeftRCol = -1;

        for (int row = 0; row < table.length - 1; row++) {
            for (int col = 0; col < table[row].length - 1; col++) {
                int currentSum = table[row][col] + table[row][col + 1] +
                        table[row + 1][col] + table[row + 1][col + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    maxSumTopLeftRow = row;
                    maxSumTopLeftRCol = col;
                }
            }
        }

        System.out.println(table[maxSumTopLeftRow][maxSumTopLeftRCol] + " " + table[maxSumTopLeftRow][maxSumTopLeftRCol + 1]);
        System.out.println(table[maxSumTopLeftRow + 1][maxSumTopLeftRCol] + " " + table[maxSumTopLeftRow + 1][maxSumTopLeftRCol + 1]);
        System.out.println(maxSum);
    }
}
