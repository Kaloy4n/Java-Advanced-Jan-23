package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P6WordCount {
    public static void main(String[] args) throws IOException {
        // Step 1.Find which words to count
        // words.txt contains words that we need to search for
        String basePath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\";
        String pathWords = basePath + "words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));

        // Create a map to hold Word -> number of occurrences
        Map<String, Integer> wordsCount = new HashMap<>();

        for (String line : allLinesWithWords) {

            String[] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> wordsCount.put(word, 0));
        }

        // Step 2. Count the number of times the words found in step 1 are in file text.txt
        String pathText = basePath + "text.txt";
        List<String> allLinesWithText = Files.readAllLines(Path.of(pathText));

        for (String line : allLinesWithText) {
            // Remove punctuation marks
            line = line.replaceAll("[.,?!:]", "");
            String[] wordsOnCurrentRow = line.split("\\s+");
            for (String word : wordsOnCurrentRow) {
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            }
        }

        // Step 3. we know each word present in both words.txt and text.txt files
        // we sort the records by number of occurrences in descending order
        // a record is: key (word) -> value (num of occurrences)
        PrintWriter writer = new PrintWriter(basePath + "results.txt");
        wordsCount.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));

        writer.close();

        // sorted (number)
        // number is 0 -> does not swap the places of the records
        // number is 1 -> swaps the places of the records
        // number is -1 -> does not swap the places of the records.

        // compareTo -> yields a whole number
        // 0 -> first num == second num
        // 1 -> first num > second num
        //-1 -> second num > first num
    }
}

