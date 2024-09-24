package StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class P4CountCharacterTypes {
    public static void main(String[] args) {
        //Assume that:
        //•	a, e, i, o, u are vowels, only lower case.
        //•	All others are other symbols.
        //•	Punctuation marks are (! , . ?).
        //•	Do not count whitespace.
        //Write the results to another file – "output.txt".

        String pathToInputFile = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\input.txt";
        String pathToOutputFile = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\output.txt";

        int vowelCount = 0;
        int punctuationCount = 0;
        int othersCount = 0;

        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationSet = Set.of('!', '@', '#', '$', '%', '^', ',', '.', '?');

        try (FileReader fileReader = new FileReader(pathToInputFile)){
            PrintStream printStream = new PrintStream(Files.newOutputStream(Path.of(pathToOutputFile)));
            int read = fileReader.read();
            while (read != -1) {
                char symbol = (char) read;
                if (vowelSet.contains(symbol)){
                    vowelCount++;
                } else if (punctuationSet.contains(symbol)){
                    punctuationCount++;
                } else if (!Character.isWhitespace(symbol)) {
                    othersCount++;
                }
                read = fileReader.read();
            }

            printStream.printf("Vowels: %d%n", vowelCount);
            printStream.printf("Other symbols: %d%n", othersCount);
            printStream.printf("Punctuation: %d", punctuationCount);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
