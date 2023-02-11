package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P8NestedFolders {
    public static void main(String[] args) {
        String folderPath = "D:\\JAVA\\SoftUni\\Java Advanced Jan23\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(folderPath);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int count = 0;

        while(!dirs.isEmpty()) {
            File currentDir = dirs.poll();
            File[] nestedFiles = currentDir.listFiles();
            assert nestedFiles != null;
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(currentDir.getName());
        }
        System.out.printf("%d folders", count);
    }
}
