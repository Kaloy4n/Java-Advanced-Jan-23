package StreamsFilesAndDirectories.Exercises;

import java.io.File;

public class P8GetFolderSize {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23\\src\\StreamsFilesAndDirectories\\Resources\\ForExercises\\Exercises Resources";
        File folder = new File(folderPath);
        long size = folderSize(folder);
        System.out.println("Folder size: " + size);
    }

    private static long folderSize(File directory) {
        long length = 0;
        File[] allFilesInFolder = directory.listFiles();
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    length += folderSize(file);
                }
            }
        }
        return length;
    }
}
