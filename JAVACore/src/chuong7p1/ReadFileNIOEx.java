package chuong7p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOEx {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = null;
        FileChannel fileChannel = null;
        File file = new File("C://Users//Admin//Downloads//io_sample.txt");
        try {
            fileInput= new FileInputStream(file);
            fileChannel = fileInput.getChannel();
            long size = fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int)size);
            fileChannel.read(buffer);
            buffer.rewind();
            System.out.println(new String(buffer.array(),"utf8"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }finally {
            if(fileChannel!=null){
                fileChannel.close();
            }
            if(fileInput!=null){
                fileInput.close();
            }
        }
    }

}
