package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P1ReadFile {
    public static void main(String[] args) {
        String filePath = "D:\\Learning & Dev\\Java\\SoftUni\\Java Advanced Sep 2024\\04-Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        // Reads byte by byte
        try (InputStream inputStream = new FileInputStream(filePath)) {

            int readByte = inputStream.read();
            while(readByte >= 0) {
                System.out.print(Integer.toBinaryString(readByte) + " ");
                readByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
