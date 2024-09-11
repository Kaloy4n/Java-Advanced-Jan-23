package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deque<String> browserHistory = new ArrayDeque<>();

    String currentInput = scanner.nextLine();

    while(!currentInput.equals("Home")) {
        if (!currentInput.isEmpty()) {
            if (currentInput.equals("back")) {
                if (browserHistory.size() == 1 || browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    currentInput = scanner.nextLine();
                    continue;
                    }

                browserHistory.pop();
                } else {
                browserHistory.push(currentInput);
                }
                System.out.println((browserHistory.peek()));
                currentInput = scanner.nextLine();
            }
        }
    }
}
