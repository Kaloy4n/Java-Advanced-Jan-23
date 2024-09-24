package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P1PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> contestantsQueue = new ArrayDeque<>();
        Deque<Integer> piesStack = new ArrayDeque<>();

        // Read contestant capacities
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(contestantsQueue::offer);

        // Read pies
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(piesStack::push);

        while (!contestantsQueue.isEmpty() && !piesStack.isEmpty()) {
            int contestantCapacity = contestantsQueue.poll();  // Remove the first contestant
            int pieSize = piesStack.pop();  // Remove the last pie

            if (contestantCapacity >= pieSize) {
                contestantCapacity -= pieSize;
                // Contestant has remaining capacity, put them back in the queue
                if (contestantCapacity > 0) {
                    contestantsQueue.offer(contestantCapacity);
                }
                // Pie is fully eaten, so no action on pies
            } else {
                pieSize -= contestantCapacity;  // Contestant eats part of the pie
                // If Pie still has pieces left, add it back to the pie stack
                if (!piesStack.isEmpty()) {
                    if (pieSize == 1) {
                    piesStack.push(pieSize + piesStack.pop());  // Add last pie piece to the next pie
                    } else {
                    piesStack.push(pieSize);  // Last pie remains, so just put it back
                    }
                } else {
                    piesStack.push(pieSize);
                }
            }
        }

        if (piesStack.isEmpty() && contestantsQueue.isEmpty()) {
            System.out.println("We have a champion!");
        } else if (piesStack.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            System.out.println("Contestants left: " + contestantsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else {
            System.out.println("Our contestants need to rest!");
            List<Integer> reversedPies = new ArrayList<>(piesStack);
            Collections.reverse(reversedPies);
            System.out.println("Pies left: " + reversedPies.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
