package SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _4_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        String[] numbers = scanner.nextLine().split(" ");

        for (String number : numbers) {
//            double currentNum = Double.parseDouble(number);
//            if (occurrences.containsKey(currentNum)) {
//                Integer count = occurrences.get(currentNum);
//                occurrences.put(currentNum, count + 1);
//            } else {
//                occurrences.put(currentNum, 1);
//            }

            // Variant 2:
            occurrences.putIfAbsent(Double.parseDouble(number), 0);
            occurrences.put(Double.parseDouble(number), occurrences.get(Double.parseDouble(number)) + 1);
        }

        for (Double currentNum : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", currentNum, occurrences.get(currentNum));
        }
    }
}
