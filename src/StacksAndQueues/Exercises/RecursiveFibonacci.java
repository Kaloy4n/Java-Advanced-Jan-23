package StacksAndQueues.Exercises;

import java.util.*;

public class RecursiveFibonacci {
    private static long[] memory;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        memory = new long[n + 1]; // to be able to collect all numbers n

        long result = fib(n);
        System.out.println(result);
        }

private static long fib(int n) {
    if (n < 2) {
        return 1;
    }

    if (memory[n] != 0) {
        return memory[n];
    }

    memory[n] = fib(n - 1) + fib(n - 2);
    return memory[n];
    }
}
