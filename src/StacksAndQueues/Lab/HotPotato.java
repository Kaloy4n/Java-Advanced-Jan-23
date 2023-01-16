package StacksAndQueues.Lab;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = sc.nextLine().split("\\s+");

        int steps = Integer.parseInt(sc.nextLine());

        Deque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, names);

        while (kids.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }

            String removedChild = kids.poll();
            System.out.println("Removed " + removedChild);
        }

        System.out.println("Last is " + kids.poll());
    }
}
