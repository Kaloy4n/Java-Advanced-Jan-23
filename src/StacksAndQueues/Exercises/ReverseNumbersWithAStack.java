package StacksAndQueues.Exercises;

import java.util.*;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersAsStrings = scanner.nextLine().split("\\s+");
        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersAsStrings.length; i++) {
            stack.push(Integer.parseInt(numbersAsStrings[i]));
        }

        for (Integer integer : stack) {
            System.out.print(stack.pop() + " ");
        }
    }
}
