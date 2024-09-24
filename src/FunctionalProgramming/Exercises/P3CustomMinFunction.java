package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P3CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<Integer[], Integer> findMinNumber = arr -> {
            int minNum = Integer.MAX_VALUE;
            for (Integer number : arr) {
                if (minNum > number) {
                    minNum = number;
                }
            }
            return minNum;
        };

        Integer[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer minNum = findMinNumber.apply(numbers);
        System.out.println(minNum);
    }
}
