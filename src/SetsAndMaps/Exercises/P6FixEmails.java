package SetsAndMaps.Exercises;

import java.util.*;


public class P6FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Map<String, String> emailsData = new LinkedHashMap<>();

        while(!"stop".equals(name)) {
            String email = scanner.nextLine();
            emailsData.put(name, email);
            name = scanner.nextLine();
        }
        emailsData.entrySet().removeIf(entry ->
                entry.getValue().endsWith("uk")
                || entry.getValue().endsWith("us")
                || entry.getValue().endsWith("com"));

        emailsData.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
