package chuong7p2;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class RandomAccessFileEx {
    public static void main(String[] args) {
        Path path = Path.of("\"C:\\Users\\Admin\\Downloads\\hanoi2java.txt\"");
        ByteBuffer buffer = ByteBuffer.allocate(15);
        try (FileChannel fc = FileChannel.open(path)){
            fc.read(buffer);
            System.out.println(new String(buffer.array()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}