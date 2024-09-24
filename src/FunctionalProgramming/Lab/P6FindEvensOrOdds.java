package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P6FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 10
        // odd
        int[] bounds = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String condition = sc.nextLine();

        if (condition.equals("odd")) {
            printNumbers(bounds, number -> number % 2 != 0);
        } else {
            printNumbers(bounds, number -> number % 2 == 0);
        }
    }

    private static void printNumbers(int[] bounds, Predicate<Integer> condition) {
        for (int number = bounds[0]; number <= bounds[1]; number++) {
            if (condition.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
