package StacksAndQueues.Lab;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    Deque<String> stack = new ArrayDeque<>();

    String expression = scanner.nextLine();

    String[] expressionParts = expression.split("\\s+");
    List<String> partsList = Arrays.asList(expressionParts);
    // stack.addAll(partsList);

    Collections.reverse(partsList);

    for (String part : partsList) {
        stack.push(part);
    }

    while (stack.size() > 1) {
        int first = Integer.parseInt(stack.pop());
        String operator = stack.pop();
        int second = Integer.parseInt(stack.pop());

        int result;
        switch (operator) {
            case "+": result = first + second; break;
            case "-": result = first - second; break;
            default:
                System.out.println("Unknown operation" + operator);
                return;
        }
        // "" + result == String.valueOf(result)
        stack.push("" + result);

        }
        System.out.println(stack.peek());
    }
}
