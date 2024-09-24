package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;


public class P4AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> prices = Arrays.stream(sc.nextLine().split(", "))
                .map(Double::parseDouble)
                .toList();

        Function<Double, Double> vatFunction = price -> price * 1.20;
//        Variant 1
//        System.out.println("Prices with VAT:");
//        for (Double price : prices) {
//            System.out.printf("%.2f%n", vatFunction.apply(price));
//        }

//        Variant 2
//        System.out.println("Prices with VAT:");
//        Consumer<Double> printPrice = price -> System.out.printf("%.2f%n", vatFunction.apply(price));
//        prices.forEach(printPrice);


//        Variant 3
        System.out.println("Prices with VAT:");
        prices.stream()
                .map(vatFunction)
                .forEach(price -> System.out.printf("%.2f%n", price));
    }
}
