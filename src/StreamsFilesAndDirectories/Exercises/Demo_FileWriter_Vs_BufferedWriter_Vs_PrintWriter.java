package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class Demo_FileWriter_Vs_BufferedWriter_Vs_PrintWriter {
    public static void main(String[] args) throws IOException {
        // WRITERS
        String pathToFile = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demoFileWriter.txt";
        String pathToFile2 = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demoBufferedWriter.txt";
        String pathToFile3 = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\demoPrintWriter.txt";

        //1. FileWriter
        File file = new File(pathToFile);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("This is a sample text written to a file using the FileWriter class.");
        fileWriter.close();

        //2. BufferedWriter -> faster than FileWriter
        BufferedWriter bfWriter = new BufferedWriter(new FileWriter(pathToFile2));
        bfWriter.write("This is a sample text written to a file using the BufferedWriter class.");
        bfWriter.close();

        //3. PrintWriter
        File fileForPrintWriter = new File(pathToFile3);

        try(PrintWriter writer = new PrintWriter(fileForPrintWriter)) {
            writer.write("This is a sample text written to a file using the PrintWriter class.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
}
