package StreamsFilesAndDirectories.Lab;

import java.io.*;

public class P3CopyBytes {
    public static void main(String[] args) {
        String basePath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\P3_output.txt";

        try(InputStream inputStream = new FileInputStream(inputPath);
            OutputStream outputStream = new FileOutputStream(outputPath)) {

                int readByte;
                while ((readByte = inputStream.read()) >= 0) {
                    // == 10 or == 32 ASCII char codes
                    if (readByte == ' ' || readByte == '\n') {
                        outputStream.write(readByte);
                    } else {
                        String number = String.valueOf(readByte);
                        for (int i = 0; i < number.length(); i++) {
                            outputStream.write(number.charAt(i));
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
