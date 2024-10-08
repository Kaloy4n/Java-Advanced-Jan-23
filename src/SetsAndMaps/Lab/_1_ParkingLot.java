package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while(!input.equals("END")) {
            String[] parts = input.split(", ");
            String direction = parts[0];
            String carNumber = parts[1];

            switch (direction) {
                case "IN" -> cars.add(carNumber);
                case "OUT" -> cars.remove(carNumber);
                default -> {
                }
            }
            input = scanner.nextLine();
        }

        if(cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
