package StacksAndQueues.Lab;

import java.util.*;

public class MatchingParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Deque<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indices.push(i);
            } else if (input.charAt(i) == ')') {
                int openBracketIndex = indices.pop();

                String expression = input.substring(openBracketIndex, i + 1);
                System.out.println(expression);
            }

        }
    }
}
