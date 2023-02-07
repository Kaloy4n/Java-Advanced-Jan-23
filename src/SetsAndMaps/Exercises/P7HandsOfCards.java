package SetsAndMaps.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P7HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> personValues = new LinkedHashMap<>();

        String input;
        while(!(input = scanner.nextLine()).equals("JOKER")) {
            String person = input.split(": ")[0];

            if (!personValues.containsKey(person)) {
                personValues.put(person, new ArrayList<>());
            } else {
                personValues.put(person, personValues.get(person));
            }

            List<String> cards = Arrays.stream(input.split(": ")[1].split(", ")).collect(Collectors.toList());
            Set<String> setOfCards = new LinkedHashSet<>();
            setOfCards.addAll(cards);

            for (String card : setOfCards) {
                String powerSymbol;
                String typeSymbol;

                if(card.length() == 2) {
                    powerSymbol = card.substring(0,1);
                    typeSymbol = card.substring(1,2);
                } else {
                    powerSymbol = card.substring(0,2);
                    typeSymbol = String.valueOf(card.charAt(2));
                }

                int powerInt = convertPowerToInt(powerSymbol);
                int typeInt = convertTypeToInt(typeSymbol);
                int currentValue = powerInt * typeInt;

                List<Integer> currentPersonValues = personValues.get(person);
                if (!currentPersonValues.contains(currentValue)) {
                    personValues.get(person).add(currentValue);
                    personValues.put(person, personValues.get(person));
                }
            }
        }

            personValues.forEach((person, valuesList) -> {
                int sumOfValues = valuesList.stream().mapToInt(Integer::intValue).sum();
                StringBuilder sb = new StringBuilder();
                System.out.println(sb.append(person)
                        .append(": ")
                        .append(sumOfValues));
            });
    }

    private static int convertPowerToInt(String powerSymbol) {
        switch (powerSymbol) {
            case "J": powerSymbol = "11";
                break;
            case "Q": powerSymbol = "12";
                break;
            case "K": powerSymbol = "13";
                break;
            case "A": powerSymbol = "14";
                break;
        }
        return Integer.parseInt(powerSymbol);
    }

    private static int convertTypeToInt(String typeSymbol) {
        switch (typeSymbol) {
            case "S": typeSymbol = "4";
                break;
            case "H": typeSymbol = "3";
                break;
            case "D": typeSymbol = "2";
                break;
            case "C": typeSymbol = "1";
                break;
        }
        return Integer.parseInt(typeSymbol);
    }
}
