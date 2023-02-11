package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P2SumBytes {
    public static void main(String[] args) throws IOException {
        //1. Get all rows from input.txt file
        String pathToFile = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0; //sum all symbols' ASCII codes

        /* List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        //2 Print the sum
        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);*/

        //2nd way
        byte[] allBytes = Files.readAllBytes(Path.of(pathToFile));
        //.readAllBytes method captures /n and /r
        //byte -> -127 to 128
        //sbyte -> 0 to 256
        for (byte ascii : allBytes) {
            //ascii = 10 is the code for new row /n
            //ascii = 13 is the code for carriage return /r
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
