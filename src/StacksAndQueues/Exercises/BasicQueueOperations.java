package StacksAndQueues.Exercises;

import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //num of elements to add to the stack
        int s = scanner.nextInt(); //num of elements to remove from the stack
        int x = scanner.nextInt(); //is present in the stack?

        //new queue initialization
        Deque<Integer> queue = new ArrayDeque<>();

        //ADD (offer or add) -> n number of times
        for (int count = 1; count <= n; count++) {
            queue.offer(scanner.nextInt());
        }

        //REMOVE (poll) -> s number of times
        for (int count = 1; count <= s; count++) {
            if (!queue.isEmpty()) {
                queue.poll();
            }
        }

        //CHECK if element is present
        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                //NOT THERE -> print the smallest element in the stack
                System.out.println(Collections.min(queue));
            }
        }
    }
}
