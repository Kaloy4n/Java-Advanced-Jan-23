package StacksAndQueues.Exercises;

import java.util.*;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        /*   String[] numbersAsStrings = scanner.nextLine().split("\\s+");
             for (int i = 0; i < numbersAsStrings.length; i++) {
                stack.push(Integer.parseInt(numbersAsStrings[i]));
             }
        */

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);

        /*  for (Integer integer : stack) {
            System.out.print(stack.pop() + " ");
            }
        */

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
