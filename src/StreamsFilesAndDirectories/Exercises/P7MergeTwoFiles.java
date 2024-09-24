package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P7MergeTwoFiles {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\ForExercises";
        String inputOneTxt = basePath + "\\inputOne.txt";
        String inputTwoTxt = basePath + "\\inputTwo.txt";
        String outputPathTxt = basePath + "\\output.txt";

        try (BufferedReader readerOne = Files.newBufferedReader(Path.of(inputOneTxt));
             BufferedReader readerTwo = Files.newBufferedReader(Path.of(inputTwoTxt));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPathTxt))) {
            String line = readerOne.readLine();

            while (line != null) {
                writer.write(line + "\n");
                line = readerOne.readLine();
            }
            line = readerTwo.readLine();
            while (line != null) {
                writer.write(line + "\n");
                line = readerTwo.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
