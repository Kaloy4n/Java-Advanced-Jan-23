package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P2KnightsOfHonour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Consumer<String> appendAndPrint = string -> System.out.println("Sir " + string);

        Arrays.stream(sc.nextLine().split("\\s+")).forEach(appendAndPrint);
    }
}
