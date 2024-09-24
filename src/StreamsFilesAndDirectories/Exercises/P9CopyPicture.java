package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P9CopyPicture {
    public static void main(String[] args) {
        String inPath = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23" +
                "\\src\\StreamsFilesAndDirectories\\Resources\\Tapir.jpg";
        String outPath = "C:\\Users\\user\\IdeaProjects\\Java-Advanced-Jan-23" +
                "\\src\\StreamsFilesAndDirectories\\Resources\\picture-copy.jpg";

        try (var fis = Files.newInputStream(Path.of(inPath));
        var fos = Files.newOutputStream(Path.of(outPath))) {
            byte[] buffer = fis.readAllBytes();
            fos.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
