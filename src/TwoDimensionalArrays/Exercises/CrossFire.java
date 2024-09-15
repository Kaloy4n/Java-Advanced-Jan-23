package TwoDimensionalArrays.Exercises;

import java.util.*;

public class CrossFire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> field = new ArrayList<>();
        initializeField(field, rows, cols);

        String command = scanner.nextLine();
        while (!"Nuke it from orbit".equals(command)) {

            String[] commandParts = command.split(" ");
            int targetRow  = Integer.parseInt(commandParts[0]);
            int targetCol  = Integer.parseInt(commandParts[1]);
            int radius = Integer.parseInt(commandParts[2]);

            destroyArea(field, targetRow , targetCol, radius);

            command = scanner.nextLine();
        }

        printMatrix(field);
    }

    private static void destroyArea(List<List<Integer>> field, int targetRow, int targetCol, int radius) {

        // Destroy horizontally (left to right) within the radius
        for (int col = targetCol - radius; col <= targetCol + radius; col++) {
            if (isInside(field, targetRow, col)) {
                field.get(targetRow).set(col, null);
            }
        }

        // Destroy vertically (top to bottom) within the radius
        for (int row = targetRow - radius; row <= targetRow + radius; row++) {
            if (isInside(field, row, targetCol)) {
                field.get(row).set(targetCol, null);
            }
        }

        // Remove destroyed elements (null values) from each row
        for (List<Integer> integers : field) {
            integers.removeIf(cell -> cell == null);
        }
        // Remove empty rows
        field.removeIf(List::isEmpty);
    }

    private static boolean isInside(List<List<Integer>> field, int row, int col) {
        return row >= 0 && row < field.size() && col >= 0 && col < field.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> field) {

        for (List<Integer> integers : field) {
            integers.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void initializeField(List<List<Integer>> field, int rows, int cols) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(counter++);
            }
            field.add(currentRow);
        }
    }
}
