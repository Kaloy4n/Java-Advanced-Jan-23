package StacksAndQueues.Lab;

import java.util.*;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> browserHistory = new ArrayDeque<>();
        Deque<String> forwardPages = new ArrayDeque<>();

        String currentInput = scanner.nextLine();

        while(!currentInput.equals("Home")) {
                if (currentInput.equals("back")) {
                    if (browserHistory.size() < 2) {
                        System.out.println("no previous URLs");
                        currentInput = scanner.nextLine();
                        continue;
                    } else {
                        forwardPages.addFirst(browserHistory.peek());
                        browserHistory.pop();
                        System.out.println(browserHistory.peek());
                    }
                } else if (currentInput.equals("forward")) {
                    if (forwardPages.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        System.out.println(forwardPages.peek());
                        browserHistory.push(forwardPages.peek());
                        forwardPages.poll();
                    }
                } else {
                    browserHistory.push(currentInput);
                    System.out.println(currentInput);
                    forwardPages.clear();
                }
                currentInput = scanner.nextLine();
            }
        }
    }

