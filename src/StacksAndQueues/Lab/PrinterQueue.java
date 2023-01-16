package StacksAndQueues.Lab;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String currentInput = sc.nextLine();

        Deque<String> printerQueue = new ArrayDeque<>();
        while (!currentInput.equals("print")) {
            if (currentInput.equals("cancel")) {
                String firstTask = printerQueue.poll();

                if (firstTask == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + firstTask);
                }

            } else {
                printerQueue.offer(currentInput);
            }
            currentInput = sc.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
