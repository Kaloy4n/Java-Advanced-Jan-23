package StacksAndQueues.Exercises;

import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCommands = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= nCommands; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("1")) {
                int elementToAdd = Integer.parseInt(command.split("\\s+")[1]);
                stack.push(elementToAdd);
            } else if (command.startsWith("2")) {
                stack.pop();
            } else if (command.startsWith("3")) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
