package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P5LineNumbers {
    public static void main(String[] args) throws IOException {
        //1.Read all rows from file inputLineNumbers.txt
        //2. Iterate through each row and write in a new file with a next number in front
        String basePath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\";
        String inputPath = basePath + "inputLineNumbers.txt";
        String outputPath = basePath + "output.txt";

        List<String> allLines = Files.readAllLines(Path.of(inputPath));

        PrintWriter writer = new PrintWriter(outputPath);

        int lineNumber = 1;
        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }
        writer.close();
    }
}
