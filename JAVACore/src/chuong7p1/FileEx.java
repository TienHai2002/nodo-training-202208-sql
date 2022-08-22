package chuong7p1;

import java.io.File;
import java.util.List;

public class FileEx {
    public static void main(String[] args) {
        File file = new File("C://Users//Admin//Downloads");
        System.out.println("This is " + (file.isFile() ? "file" : "folder" ) + "!");
        File[] files = file.listFiles();
        for(File f:files){
            System.out.println(f.getName()+":"+f.length()+"bytes");
        }
        if (file.isFile()){
            System.out.println("this is folder");
        }else {
            System.out.println("this is file");
        }

    }
}
