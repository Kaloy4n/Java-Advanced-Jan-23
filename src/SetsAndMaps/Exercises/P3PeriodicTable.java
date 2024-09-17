package SetsAndMaps.Exercises;

import java.util.*;

public class P3PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            // Alternative way:
            // elements.addAll(Arrays.asList(input));
            Collections.addAll(elements, input);
        }

        String result = String.join(" ", elements);
        System.out.println(result);
    }
}
