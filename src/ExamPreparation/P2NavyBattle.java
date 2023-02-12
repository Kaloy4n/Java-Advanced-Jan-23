package ExamPreparation;

import java.util.Scanner;

public class P2NavyBattle {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Read the size of the battlefield
        int n = Integer.parseInt(scanner.nextLine());

        // Create the battlefield
        String[][] matrix = new String[n][n];
        fillMatrix(matrix);

        // Where is my submarine located
        int submarineRow = -1;
        int submarineCol = -1;
        int countHits = 0;
        int countCruiser = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();

        label:
        while(true) {
            // Remove submarine's current position as it's now moving
            matrix[submarineRow][submarineCol] = "-";
            // Perform the move
            switch (command) {
                case "up" -> submarineRow--;
                case "down" -> submarineRow++;
                case "right" -> submarineCol++;
                case "left" -> submarineCol--;
            }
            String submarinePosition =matrix[submarineRow][submarineCol];
            switch (submarinePosition) {
                    // Add last known position
                case "-" -> matrix[submarineRow][submarineCol] = "S";
                case "*" -> {
                    // Add last known position
                    matrix[submarineRow][submarineCol] = "S";
                    // Mine that destroys us
                    countHits++;
                    if (countHits == 3) {
                        System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                        break label;
                    }
                }
                case "C" -> {
                    // Add last known position
                    matrix[submarineRow][submarineCol] = "S";
                    // Cruisers we destroy
                    countCruiser++;
                    if (countCruiser == 3) {
                        System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                        break label;
                    }
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }


    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}