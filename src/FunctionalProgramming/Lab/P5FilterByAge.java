package FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P5FilterByAge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();

        // 5
        // Peter, 20
        // George, 18
        // Maria, 29
        // Idan, 31
        // Simeon, 16
        // older
        // 20
        // name age

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String name = line.split(", ")[0];
            int age = Integer.parseInt(line.split(", ")[1]);
            people.putIfAbsent(name, age);
        }

        //•	Condition - "younger" or "older"
        //•	Age - Integer
        //•	Format - "name", "age" or "name age"

        String condition = sc.nextLine();
        int ageLimit = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        Predicate<Integer> ageCheck;
        if (condition.equals("younger")) {
            ageCheck = personAge -> personAge <= ageLimit;
        } else {
            ageCheck = personAge -> personAge >= ageLimit;
        }

        Consumer<Map.Entry<String, Integer>> print;
        if (format.equals("name")) {
            print = entry -> System.out.println(entry.getKey());
        } else if (format.equals("age")) {
            print = entry -> System.out.println(entry.getValue());
        } else {
            print = entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        people.entrySet()
                .stream()
                .filter(entry -> ageCheck.test(entry.getValue()))
                .forEach(print);
    }
}
