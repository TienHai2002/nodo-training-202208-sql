package chuong7p1;

import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessEx {
    public static void main(String[] args) throws Exception {
        File file = new File("C://Users//Admin//Downloads//io_sample.txt");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
            randomAccessFile.seek(9);
            byte[] bytes = new byte[4*102];
            int read = randomAccessFile.read(bytes);
            System.out.println(new String(bytes,0,read,"utf8"));
            randomAccessFile.seek(file.length());
            randomAccessFile.write("\r\n".getBytes());
            randomAccessFile.writeChars("hello ");
            Desktop.getDesktop().open(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
