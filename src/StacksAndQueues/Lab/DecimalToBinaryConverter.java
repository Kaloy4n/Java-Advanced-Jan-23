package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Short> bits = new ArrayDeque<>();

        int num = Integer.parseInt(sc.nextLine());

        if (num < 0) {
            System.out.println("Cannot handle negative integers");
            return;
        }
        if (num == 0) {
            System.out.println(0);
            return;
        }

        while (num > 0) {
            short bit = (short) (num % 2);
            bits.push(bit);
            num = num / 2;
        }

        while (!bits.isEmpty()) {
            System.out.print(bits.pop());
        }
    }
}
