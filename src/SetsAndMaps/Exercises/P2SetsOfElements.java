package SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P2SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sizeOf1stSet = Integer.parseInt(input.split(" ")[0]);
        int sizeOf2ndSet = Integer.parseInt(input.split(" ")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        //1. Fill the 1st set
        for (int number = 1; number <= sizeOf1stSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }

        //2. Fill the 2nd set
        for (int number = 1; number <= sizeOf2ndSet; number++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }

        //3. Find common elements of the 2 sets and print them.

        // 1st way to solve it:
//        for (Integer number : firstSet) {
//            if(secondSet.contains(number)) {
//                System.out.print(number + " ");
//            }
//        }

        //2nd way to solve it:
        firstSet.retainAll(secondSet);
        //retainAll removes all elements of the first Set that are not present in the 2nd one.
        //in the 1st set remain only elements that are present in the 2nd -> only duplicated elements between the 2 sets remain.
        firstSet.forEach(el -> System.out.print(el + " "));
    }
}
