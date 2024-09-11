package StacksAndQueues.Lab;

import java.math.BigDecimal;
import java.util.*;

public class DecimalFractionalToBinaryConverter {
    public static void main(String[] args) {
        /*
        * Not all fractions can be exactly converted to binary: only if the denominator is a power of 2, the binary fraction will be finite.
        * In every other case, there will be an error in the representation.
        * The error's magnitude depends on the number of digits used to represent it.
        * */
        Scanner scanner = new Scanner(System.in);

        double doubleNumber = Double.parseDouble(scanner.nextLine());

        Deque<Short> bitsIntegerPart = new ArrayDeque<>();
        Deque<Short> bitsFractionalPart = new ArrayDeque<>();

        if (doubleNumber < 0.0) {
            System.out.println("Cannot handle negative decimals.");
            return;
        } else if (doubleNumber == 0.0) {
            System.out.println(0);
            return;
        } else {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(doubleNumber));
            int integerPart = bigDecimal.intValue();
            System.out.println("Integer part: " + integerPart);
            double fractionalPart = bigDecimal.subtract(new BigDecimal(integerPart)).doubleValue();
            System.out.println("Fractional part: " + fractionalPart);

            if (integerPart == 0) {
                bitsIntegerPart.push((short) 0);
            }
            // Repeat the steps until the integer part is equal to 0
            while (integerPart > 0) {
                // Get the remainder from dividing the integer by 2 which is the corresponding bit
                short bitInteger = (short) (integerPart % 2);
                // Add the remainder to a stack (as we need to reverse the order of all bits to get the binary representation)
                bitsIntegerPart.push(bitInteger);
                // Divide the integer part by 2 from the current iteration for use in the next one
                integerPart = integerPart / 2;
                // If the integer part reaches 0 add a residual bit of 0
                }

            // Repeat the steps until the fractional part is equal to 0
            while (fractionalPart > 0.0) {
                // Multiply the number by 2
                fractionalPart = fractionalPart * 2;
                // Remember the integer remainder for the binary digit
                short bitFractional = (short) fractionalPart;
                // Add the bit in a queue (non-reverse order)
                bitsFractionalPart.offer(bitFractional);
                // Get the fractional part from the current iteration for use in the next one
                fractionalPart = fractionalPart - bitFractional;
                // If the fractional part reaches 0.0 add a residual bit of 0
                if (fractionalPart == 0.0) {
                    bitsFractionalPart.offer((short) 0);
                }
            }
        }

        short counterBinaryInteger = 0;
        while (!bitsIntegerPart.isEmpty()) {
            System.out.print(bitsIntegerPart.pop());
            counterBinaryInteger += 1;
            if (counterBinaryInteger == 32) {
                break;
            }
        }

        System.out.print(".");

        int counterBinaryFraction = 0;
        while (!bitsFractionalPart.isEmpty()) {
            System.out.print(bitsFractionalPart.poll());
            counterBinaryFraction += 1;
            // Display only up to 32 digits after the decimal point when the binary fraction is infinite.
            if (counterBinaryFraction == 32) {
                break;
            }
        }
    }
}
