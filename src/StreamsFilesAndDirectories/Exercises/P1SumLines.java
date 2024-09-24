package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P1SumLines {
    public static void main(String[] args) throws IOException {
        //1. Get all rows from input.txt file
        String pathToFile = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\" +
                "StreamsFilesAndDirectories\\Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

/*        2. For each row find the sum of the ASCII chars and print it
*        2.1 one way to solve it
*        for (String line : allLines) {
*            //line = "Michael Angelo,"
*            int sum = 0;
*            for (char symbol : line.toCharArray()) {
*                sum += symbol;
*            }
*            System.out.println(sum);
*        }
*/
        //2.2 second way to solve it
        allLines.forEach(line -> {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        });
    }
}
