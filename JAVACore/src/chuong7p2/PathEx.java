package chuong7p2;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class PathEx {
    public static void main(String[] args) {
//        try {
//            Path path = Paths.get("C:\\Users\\Admin\\Downloads");
//            System.out.println("this is: "+(Files.isDirectory(path)?"file":"folder"));
//            System.out.println(Files.exists(path));
//            DirectoryStream directoryStream = Files.newDirectoryStream(path);
//            for (Object p:directoryStream){
//                System.out.println(p);
//            }
//
//            Path path2 = path.resolve("test.txt");
//            Charset charset = Charset.forName("utf8");
//            try(BufferedReader reader=Files.newBufferedReader(path2,charset)){
//                String line =null;
//                while ((line=reader.readLine())!=null){
//                    System.out.println(line);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
        //ex2
        Path path = Paths.get("\"C:\\Users\\Admin\\Downloads\\hanoijava.txt\"");
        Charset charset = Charset.forName("UTF8");
        try (BufferedWriter writer = Files.newBufferedWriter(path,charset)){
            for(int i=0;i<10;i++){
                writer.write("Nguyen Van  "+i+"\r\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }
