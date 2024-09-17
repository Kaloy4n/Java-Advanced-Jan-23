package SetsAndMaps.Lab;

import java.util.*;

public class _3_WarNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(deckOne::add);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(deckTwo::add);

//        String[] inputOne = scanner.nextLine().split(" ");
//        String[] inputTwo = scanner.nextLine().split(" ");

//        for (String card : inputOne) {
//            int current = Integer.parseInt(card);
//            deckOne.add(current);
//        }

//        for (String card : inputTwo) {
//            int current = Integer.parseInt(card);
//            deckTwo.add(current);
//        }

        int step = 1;
        while(step <= 50) {
            // fight logic

            Integer fighterOne = deckOne.iterator().next();
            deckOne.remove(fighterOne);

            Integer fighterTwo = deckTwo.iterator().next();
            deckTwo.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterTwo > fighterOne) {
                deckTwo.add(fighterOne);
                deckTwo.add(fighterTwo);
            }
            step++;
        }

        if (deckOne.size() < deckTwo.size()) {
            System.out.println("Second player win!");
        } else if (deckOne.size() > deckTwo.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
