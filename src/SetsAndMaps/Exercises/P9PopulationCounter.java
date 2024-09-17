package SetsAndMaps.Exercises;

import java.util.*;


public class P9PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesTotalPopulation = new LinkedHashMap<>();

        while(!"report".equals(line)){
            //Sofia|Bulgaria|1000000
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);

            countriesTotalPopulation.putIfAbsent(country, 0L);
            long totalPopulationToAdd = countriesTotalPopulation.get(country) + population;
            countriesTotalPopulation.put(country, totalPopulationToAdd);

            line = sc.nextLine();
        }

        countriesTotalPopulation
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue());

                    Map<String, Long> cities = countries.get(entry.getKey());

                    cities.entrySet()
                            .stream()
                            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                            .forEach(cityEntry -> System.out.printf("=>%s: %d%n", cityEntry.getKey(),
                                    cityEntry.getValue()));

                });
    }
}
