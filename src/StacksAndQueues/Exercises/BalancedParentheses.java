package StacksAndQueues.Exercises;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Character> openBracketsStack = new ArrayDeque<>();
        Deque<Character> closedBracketsQueue = new ArrayDeque<>();

        boolean areSymbolsBalanced = false;

        label:
        //"{[()]}" -> .toCharArray() -> ['{', '[', '('...]
        for (char symbol : input.toCharArray()) {
            switch (symbol) {
                case '(':
                case '[':
                case '{':
                    //open {, [, ( -> add to stack i.e. LIFO
                    openBracketsStack.push(symbol);
                    break;
                case ')':
                case ']':
                case '}':
                    //closed ), ], } -> add to queue i.e. FIFO
                    closedBracketsQueue.offer(symbol);
                    break;
                default:
                    break label;
            }
            if(!openBracketsStack.isEmpty() && !closedBracketsQueue.isEmpty()) {
                if (openBracketsStack.peek() == '(' && closedBracketsQueue.peek() == ')' || openBracketsStack.peek() == '[' && closedBracketsQueue.peek() == ']' || openBracketsStack.peek() == '{' && closedBracketsQueue.peek() == '}') {
                    areSymbolsBalanced = true;
                    openBracketsStack.pop();
                    closedBracketsQueue.poll();
                } else {
                    areSymbolsBalanced = false;
                }
            } else if (openBracketsStack.isEmpty() || closedBracketsQueue.isEmpty()) {
                areSymbolsBalanced = false;
            }
        }

        if(areSymbolsBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
