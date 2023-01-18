package StacksAndQueues.Exercises;

import java.util.*;

public class FibonacciWIthStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());

        Deque<Long> stack = new ArrayDeque<>();

        stack.push(0L);
        stack.push(1L);

        if (n <= 0) {
            System.out.println(0L);
            return;
        }

        for (int i = 0; i < n; i++) {
            long rightNum = stack.pop();
            long leftNum = stack.pop();
            stack.push(rightNum);
            stack.push(leftNum + rightNum);
        }

        System.out.println(stack.pop());
    }
}
