package MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // num of rows == num of columns
        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        int km = 0;

        // initialize a square matrix
        String [][] track = new String[n][n];

        fillMatrix(track);

        int carCurrentRow = 0; //row where the car is located
        int carCurrentCol = 0; //column where the car is located

        // Finding the tunnels
        // Tunnel 1 -> row, column locator
        // Tunnel 2 -> row, column locator
        // Create a list with 4 elements
        // -> 1st el (row of tunnel 1), 2nd el (col of tunnel 1)
        // -> 3rd el (row of tunnel 2), 4th el (col of tunnel 2)

        List<Integer> tunnelCoordinates = new ArrayList<>();
        findTunnelsPositions(track, tunnelCoordinates);

        // Commence movements
        String direction = scanner.nextLine();

        while (!direction.equals("End")) {
            switch (direction) {
                case "left" -> carCurrentCol--;
                case "right" -> carCurrentCol++;
                case "up" -> carCurrentRow--;
                case "down" -> carCurrentRow++;
            }
            // currentRow, currentCol -> coordinate of the car position
            String movedPlace = track[carCurrentRow][carCurrentCol];

            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                km += 10;
                break;
            } else if (movedPlace.equals("T")) {
                // When reaching a tunnel we jump from the 1st to the 2nd tunnel
                // Coordinates of the car => coordinates of the 2nd tunnel
                carCurrentRow = tunnelCoordinates.get(2);
                carCurrentCol = tunnelCoordinates.get(3);
                km += 30;
                // Replace the tunnels with a dot because we've already passed through
                track[tunnelCoordinates.get(0)][tunnelCoordinates.get(1)] = ".";
                track[tunnelCoordinates.get(2)][tunnelCoordinates.get(3)] = ".";
            }
            direction = scanner.nextLine();
        }

        if(direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }

        System.out.printf("Distance covered %d km.%n", km);

        // Insert 'C' where the car is located
        track[carCurrentRow][carCurrentCol] = "C";
        // Print the state of the final track
        printMatrix(track);
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    
    private static void findTunnelsPositions(String[][] track, List<Integer> tunnelsCoordinates) {
        for (int row = 0; row < track.length; row++) {
            for (int col = 0; col < track[0].length; col++) {
                if (track[row][col].equals("T")) {
                    tunnelsCoordinates.add(row);
                    tunnelsCoordinates.add(col);
                }
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
