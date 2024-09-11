package StacksAndQueues.Exercises;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // "5 2 13"

        //1st way to read
        int n = scanner.nextInt(); //num of elements to add to the stack
        int s = scanner.nextInt(); //num of elements to remove from the stack
        int x = scanner.nextInt(); //is present in the stack?

        //2nd way to read
        //scanner.nextLine().split(" ") -> ["5", "2", "13"]

        //new stack initialization
        Deque<Integer> stack = new ArrayDeque<>();

        //ADD (push) -> n number of times
        for (int count = 1; count <= n; count++) {
            stack.push(scanner.nextInt());
        }

        //REMOVE (pop) -> s number of times
        for (int count = 1; count <= s; count++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        //CHECK if element is present
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
            //NOT THERE -> print the smallest element in the stack
            System.out.println(Collections.min(stack));
            }
        }
    }
}
