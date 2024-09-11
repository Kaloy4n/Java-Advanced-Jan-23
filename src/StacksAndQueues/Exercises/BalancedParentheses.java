package StacksAndQueues.Exercises;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Character> openBracketsStack = new ArrayDeque<>();
        Deque<Character> closedBracketsQueue = new ArrayDeque<>();

        boolean areSymbolsBalanced = false;

        //"{[()]}" -> .toCharArray() -> ['{', '[', '('...]
        for (char symbol : input.toCharArray()) {
            switch (symbol) {
                case '(', '[', '{' ->
                    //open {, [, ( -> add to stack i.e. LIFO
                    openBracketsStack.push(symbol);

                case ')', ']', '}' ->
                    //closed ), ], } -> add to queue i.e. FIFO
                    closedBracketsQueue.offer(symbol);
            }
            if (!openBracketsStack.isEmpty() && !closedBracketsQueue.isEmpty()) {
                if (openBracketsStack.peek() == '(' && closedBracketsQueue.peek() == ')'
                        || openBracketsStack.peek() == '[' && closedBracketsQueue.peek() == ']'
                        || openBracketsStack.peek() == '{' && closedBracketsQueue.peek() == '}') {
                    areSymbolsBalanced = true;
                    openBracketsStack.pop();
                    closedBracketsQueue.poll();
                } else {
                    areSymbolsBalanced = false;
                }
            } else {
                areSymbolsBalanced = false;
            }
        }

        if (areSymbolsBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
