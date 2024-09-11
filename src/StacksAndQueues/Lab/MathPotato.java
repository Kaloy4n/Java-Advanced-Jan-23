package StacksAndQueues.Lab;

import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] names = sc.nextLine().split("\\s+");
    int steps = Integer.parseInt(sc.nextLine());

    PriorityQueue<String> kids = new PriorityQueue<>();
    Collections.addAll(kids, names);

    int currentStep = 1;
    while (kids.size() > 1) {
        if(isPrime(currentStep)) {
            System.out.println("Prime " + kids.peek());
        } else {
            String removedChild = kids.poll();
            System.out.println("Removed " + removedChild);
        }
        currentStep++;
    }
    System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
