package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class P3AllCapitals {
    public static void main(String[] args) throws IOException {
        //1. Get all rows from file input.txt
        //2. iterate through each row -> make all letters capital -> write the row with the capital letters in a new file
        String pathToInputFile = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathToOutputFile = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathToOutputFile));
        /*
        First way of solving
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
        */

        // Second way of solving
        BufferedReader reader = new BufferedReader(new FileReader(pathToInputFile));
        //the BufferedReader is reading line by line, not all lines at once.

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
    }
}
