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
        String basePath = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\ForExercises";
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
