package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P3AllCapitals {
    public static void main(String[] args) {
        //1. Get all rows from file input.txt
        //2. iterate through each row -> make all letters capital -> write the row with the capital letters in a new file
        String pathToInputFile = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\input.txt";
        String pathToOutputFile = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\output.txt";

        /*
        First way of solving
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
        */

        try (var writer = Files.newBufferedWriter(Path.of(pathToOutputFile))) {
            // Second way of solving
            try (var reader = Files.newBufferedReader(Path.of(pathToInputFile))) {
                //the BufferedReader is reading line by line, not all lines at once.
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toUpperCase());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
