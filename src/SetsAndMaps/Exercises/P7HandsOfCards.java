package SetsAndMaps.Exercises;

import java.util.*;

public class P7HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playersValues = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"JOKER".equals(line)) {
            String[] tokens = line.split(": ");
            String playerName = tokens[0];
            String[] cards = tokens[1].split(", ");

            playersValues.computeIfAbsent(playerName, k -> new LinkedHashSet<>())
                    .addAll(List.of(cards));

//            personValues.putIfAbsent(playerName, new HashSet<>());
//            for (String card : cards) {
//                personValues.get(playerName).add(card);
//            }

            // io.vavr external library with better implementation of collections

            line = scanner.nextLine();
        }

        playersValues.forEach((key, value) -> {
                    int points = calculatePoints(value);
                    System.out.printf("%s: %d%n", key, points);
                }
        );
    }

    private static int calculatePoints(Set<String> cards) {
        Map<String, Integer> powerMap = new HashMap<>(Map.of("1", 1,
                                                            "2",2,
                                                            "3",3,
                                                            "4",4,
                                                            "5",5,
                                                            "6",6,
                                                            "7",7,
                                                            "8",8,
                                                            "9",9,
                                                            "10",10));
        powerMap.put("J", 11);
        powerMap.put("Q", 12);
        powerMap.put("K", 13);
        powerMap.put("A", 14);

        Map<String, Integer> typeMap = Map.of("S", 4,
                "H",3,
                "D",2,
                "C",1);

        int points = 0;

        for (String card : cards) {
            String cardPower = card.substring(0, card.length() - 1);
            String type = String.valueOf(card.charAt(card.length() - 1));

            Integer power = powerMap.get(cardPower);
            Integer typeValue = typeMap.get(type);
            points += power * typeValue;
        }
        return points;
    }
}


