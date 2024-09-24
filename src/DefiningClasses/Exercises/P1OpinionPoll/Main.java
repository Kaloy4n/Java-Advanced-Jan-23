package DefiningClasses.Exercises.P1OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            people.add(new Person(name, age));
        }
        people.stream()
                .filter(person -> person.getAge() > 30)
                // .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
