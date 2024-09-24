package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P4AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .toList();

        // "add" -> adds 1;
        Function<List<Long>, List<Long>> add = list -> list.stream()
                .map(n -> n + 1)
                .toList();

        // "multiply" -> multiplies by 2;
        Function<List<Long>, List<Long>> multiply = list -> list.stream()
                .map(n -> (n * 2)).toList();


        // "subtract" -> subtracts 1;
        Function<List<Long>, List<Long>> subtract = list -> list.stream()
                .map(n -> (n - 1)).toList();

        // "print" -> prints all numbers on a new line
        Consumer<List<Long>> print = list -> list.forEach(n -> System.out.print(n + " "));

        String command = sc.nextLine();

        while (!"end".equals(command)) {
            switch (command) {
                case "add" -> numbers = add.apply(numbers);
                case "multiply" -> numbers = multiply.apply(numbers);
                case "subtract" -> numbers =subtract.apply(numbers);
                case "print" -> {
                    print.accept(numbers);
                    System.out.println();
                }
                default -> throw new IllegalStateException("Unexpected value: " + command);
            }
            command = sc.nextLine();
        }
    }
}
