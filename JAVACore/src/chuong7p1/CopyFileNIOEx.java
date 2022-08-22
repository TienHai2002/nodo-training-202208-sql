package chuong7p1;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;

public class CopyFileNIOEx {
    public static void main(String[] args)throws Exception {
        try{
            File sourceFile = new File("C://Users//Admin//Downloads//io_sample.txt");
            File desFile = new File(sourceFile.getParentFile() ,"sample2.txt");
            FileChannel srcChannel = null;
            FileChannel desChannel = null;
            srcChannel = new FileInputStream(sourceFile).getChannel();
            desChannel = new FileOutputStream(desFile).getChannel();
            srcChannel.transferTo(0,srcChannel.size(),desChannel);
            Desktop.getDesktop().open(sourceFile.getParentFile());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}