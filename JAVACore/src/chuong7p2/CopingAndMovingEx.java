package chuong7p2;

import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopingAndMovingEx {
    public static void main(String[] args) {
        try{
            Path source = Path.of("\"C:\\Users\\Admin\\Downloads\\hanoijava.txt\"");
            Path target = Path.of("\"C:\\Users\\Admin\\Downloads\\io_sample.txt\"");
            Files.copy(source,target,REPLACE_EXISTING);
//            Files.delete(target);
//            Files.createLink(target,source);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}