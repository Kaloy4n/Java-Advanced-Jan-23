package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P8CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sort all even numbers before all odd ones in ascending order
        // Comparator is a function that has 2 parameters and return int (0, 1, -1)
        //  0 -> first == second
        //  1 -> first > second
        // -1 -> second < first
        // sorted(0) -> not swap the elements
        // sorted(1) -> swap the elements
        // sorted(-1) -> not swap the elements

        // 1 2 3 4 5 6 -> 2 4 6 1 3 5
        // (1, 2) -> if (el1 % 2 == 0 && el2 % 2 != 0) {return 1)} else {return -1)}


        Comparator<Integer> customComparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) { return -1; }
            else if (first % 2 != 0 && second % 2 == 0) { return 1; }
            // sort ascending order
            else {return first.compareTo(second);}
        };

        Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(customComparator)
                .forEach(n -> System.out.print(n + " "));
    }
}
