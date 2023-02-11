package StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.util.Objects;

public class P8GetFolderSize {
    public static void main(String[] args) {
        String folderPath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\Java Advanced Jan23\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(folderPath);
        long size = folderSize(folder);
        System.out.println("Folder size: " + size);
    }

    private static long folderSize(File directory) {
        long length = 0;
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += folderSize(file);
            }
        }
        return length;
    }
}
