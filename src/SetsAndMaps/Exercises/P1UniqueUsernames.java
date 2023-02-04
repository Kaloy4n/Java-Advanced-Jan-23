package SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P1UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueNames = new LinkedHashSet<>();

        for (int countWords = 1; countWords <= n; countWords++) {
            String word = scanner.nextLine();
            uniqueNames.add(word);
        }

        uniqueNames.forEach(System.out::println);
    }
}
