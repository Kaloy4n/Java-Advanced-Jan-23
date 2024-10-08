package StreamsFilesAndDirectories.Lab;

import java.io.File;

public class P7ListFiles {
    public static void main(String[] args) {
        String folderPath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\04. Java-Advanced-Files-and-Streams-Lab-Resources" +
                "\\Files-and-Streams";

        File file = new File(folderPath);
        
        File[] nestedFiles = file.listFiles();

        assert nestedFiles != null;
        for (File nestedFile : nestedFiles)  {
            if (nestedFile.isFile()) {
                System.out.printf("%s: [%d]%n", nestedFile.getName(), nestedFile.length());
            }
        }
    }
}
