package SetsAndMaps.Lab;

import java.util.*;

public class _2_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sample:
        // 7IK9Yo0h
        // 9NoBUajQ
        // Ce8vwPmE
        // SVQXQCbc
        // tSzE5t0p
        // PARTY
        // 9NoBUajQ
        // Ce8vwPmE
        // SVQXQCbc
        // END

        Set<String> guests = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            guests.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {
            guests.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }
}

