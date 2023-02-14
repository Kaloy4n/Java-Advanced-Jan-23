package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P1Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bombEffects = Arrays.stream((scanner.nextLine().split(",\\s+")))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> bombCasings = Stream.of(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

/*      To add all list elements in a Deque as a Stack not Queue ->
**      Deque<Integer> bombCasingsStack = new ArrayDeque<>();
**      bombCasings.forEach(bombCasingsStack::push);
*/

        Map<String, Integer> bombPouch = new TreeMap<>(Map.of("Datura Bombs", 0,
                                                            "Cherry Bombs", 0,
                                                            "Smoke Decoy Bombs", 0));


        while(!bombEffects.isEmpty() && !bombCasings.isEmpty() && !isBombPouchFull(bombPouch)) {

            int lastIndexOfBombCasings = bombCasings.size() - 1;
            int bomb = bombEffects.peek() + bombCasings.get(lastIndexOfBombCasings);

            switch (bomb) {
                case 40:
                    bombPouch.put("Datura Bombs", bombPouch.get("Datura Bombs") + 1);
                    bombEffects.poll(); //FIFO or queue
                    bombCasings.remove(lastIndexOfBombCasings);
                    break;
                case 60:
                    bombPouch.put("Cherry Bombs", bombPouch.get("Cherry Bombs") + 1);
                    bombEffects.poll(); //FIFO or queue
                    bombCasings.remove(lastIndexOfBombCasings);
                    break;
                case 120:
                    bombPouch.put("Smoke Decoy Bombs", bombPouch.get("Smoke Decoy Bombs") + 1);
                    bombEffects.poll(); //FIFO or queue
                    bombCasings.remove(lastIndexOfBombCasings);
                    break;
                default:
                    bombCasings.set(lastIndexOfBombCasings, bombCasings.get(lastIndexOfBombCasings) - 5);
                    break;
            }
        }

        if(isBombPouchFull(bombPouch)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (bombEffects.isEmpty()) {
            System.out.println("empty");
        } else {
            String effects = bombEffects.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(effects);
        }
        System.out.print("Bomb Casings: ");
        if (bombCasings.isEmpty()) {
            System.out.println("empty");
        } else {
            String effects = bombCasings.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(effects);
        }
        bombPouch.entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static boolean isBombPouchFull(Map<String, Integer> bombPouch) {
        return  bombPouch.get("Datura Bombs") >= 3
                && bombPouch.get("Cherry Bombs") >= 3
                && bombPouch.get("Smoke Decoy Bombs") >= 3;
    }
}
