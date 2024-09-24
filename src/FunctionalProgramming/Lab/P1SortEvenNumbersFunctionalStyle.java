package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1SortEvenNumbersFunctionalStyle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input:
        // 4, 2, 1, 3, 5, 7, 1, 4, 2, 12
        List<Integer> evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(eliminateBrackets(evenNumbers));
        Collections.sort(evenNumbers);
        System.out.println(eliminateBrackets(evenNumbers));
    }

    private static String eliminateBrackets(List<Integer> evenNumbers) {
        return evenNumbers.toString().replaceAll("[\\[\\]]", "");
    }
}
