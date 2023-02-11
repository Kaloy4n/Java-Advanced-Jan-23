package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class P2WriteToFile {
    public static void main(String[] args) throws IOException {
        String basePath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\output.txt";

        List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

        OutputStream outputStream = new FileOutputStream(outputPath);

        try (InputStream inputStream = new FileInputStream(inputPath)) {
            int readByte;
            while ((readByte = inputStream.read()) >= 0) {

                if (!punctuation.contains((char)readByte)) {
                    outputStream.write(readByte);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        outputStream.close();
    }
}
