package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P5ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        int n = Integer.parseInt(sc.nextLine());

        Predicate<Integer> isNotDivisibleByN = num -> num % n != 0;
        Consumer<Integer> print = num -> System.out.print(num + " ");
        numbers.stream()
                .filter(isNotDivisibleByN)
                .forEach(print);
    }
}
