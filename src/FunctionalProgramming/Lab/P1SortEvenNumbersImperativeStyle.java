package FunctionalProgramming.Lab;

import java.util.*;

public class P1SortEvenNumbersImperativeStyle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input:
        // 4, 2, 1, 3, 5, 7, 1, 4, 2, 12
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toList();

        List<Integer> evenNumbers = new ArrayList<>();

        // Print the even numbers
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        // Print the even numbers
        printEvenNumbers(evenNumbers);

        // Sort them in ascending order
        Collections.sort(evenNumbers);

        // Print them again
        printEvenNumbers(evenNumbers);

    }

    private static void printEvenNumbers(List<Integer> evenNumbers) {
        for (Integer evenNumber : evenNumbers) {
            System.out.print(evenNumber + " ");
        }
        System.out.println();
    }
}
