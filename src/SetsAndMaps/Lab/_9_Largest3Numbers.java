package SetsAndMaps.Lab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _9_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (String el : input) {
            numbers.add(Integer.parseInt(el));
        }

        List<Integer> sorted = numbers
            .stream()
            .sorted(Comparator.reverseOrder())
            .toList();

        int limit = Math.min(sorted.size(), 3);

        for (int i = 0; i < limit; i++) {
            System.out.print(sorted.get(i) + " ");
        }

    }
}
