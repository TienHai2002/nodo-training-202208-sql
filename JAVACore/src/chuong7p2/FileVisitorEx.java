package chuong7p2;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import static java.nio.file.FileVisitResult.CONTINUE;
public class FileVisitorEx {

    public static class PrintFiles extends SimpleFileVisitor<Path> {
        public FileVisitResult visitResult(File file){
            System.out.println(file.getAbsolutePath()+"is file");
            return CONTINUE;
        }
        public FileVisitResult posVisitResult(File file){
            System.out.println(file.mkdir()+"is directory");
            return CONTINUE;
        }

        public static void main(String[] args) {
            Path path = Path.of("\"C:\\Users\\Admin\\Downloads\"");
            try {
                Files.walkFileTree(path,new PrintFiles());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}