package chuong7p2;

import java.nio.file.*;
import static java.nio.file.FileVisitResult.CONTINUE;

public class FileFinderEx {
    class Finder extends SimpleFileVisitor{
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");
        public FileVisitResult visitResult(Path path){
            if(matcher.matches(path.getFileName())){
                System.out.println("found "+path);
            }
            return CONTINUE;
        };
    }
    public void main(String[] args) {
        try {
            Finder finder = new Finder();
            Path path = Path.of("\"C:\\Users\\Admin\\Downloads\\hanoijava.txt\"");
            FileVisitor<? super Path> Finder;
            Files.walkFileTree(Path.of("\"C:\\Users\\Admin\\Downloads\""),finder);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}