package Exam20102024;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P1BallGame {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        Deque<Integer> strength = Arrays.stream((sc.nextLine().split(" ")))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> accuracy = Stream.of(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int scoredGoals = 0;
        while (!strength.isEmpty() && !accuracy.isEmpty()) {
            int lastStrength = strength.peekLast();
            int firstAccuracy = accuracy.get(0);
            int sum = lastStrength + firstAccuracy;
            if (sum == 100) {
                scoredGoals++;
                strength.removeLast();
                accuracy.remove(0);
            }
            if (sum < 100) {
                if (lastStrength < firstAccuracy) {
                    strength.removeLast();
                }
                if (lastStrength > firstAccuracy) {
                    accuracy.remove(0);
                }
                if (lastStrength == firstAccuracy) {
                    strength.removeLast();
                    strength.addLast(sum);
                    accuracy.remove(0);
                }
            }
            if (sum > 100) {
                strength.removeLast();
                lastStrength -= 10;
                strength.addLast(lastStrength);
                accuracy.remove(0);
                accuracy.add(accuracy.size(), firstAccuracy);
            }
        }

        if (scoredGoals == 3) {
            System.out.println("Paul scored a hat-trick!");
        }
        if (scoredGoals == 0) {
            System.out.println("Paul failed to score a single goal.");
        }
        if (scoredGoals > 3) {
            System.out.println("Paul performed remarkably well!");
        }
        if (scoredGoals > 0 && scoredGoals < 3) {
            System.out.println("Paul failed to make a hat-trick.");
        }
        if (scoredGoals > 0) {
            System.out.printf("Goals scored: %d\n", scoredGoals);
        }
        if (!strength.isEmpty() || !accuracy.isEmpty()) {
            if (!strength.isEmpty()) {
                String result = "Strength values left: " +
                        strength.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(", "));
                System.out.println(result);
            }
            if (!accuracy.isEmpty()) {
                String result = "Accuracy values left: " +
                        accuracy.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(", "));
                System.out.println(result);
            }
        }
    }
}
