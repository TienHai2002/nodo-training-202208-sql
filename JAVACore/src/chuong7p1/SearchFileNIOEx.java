package chuong7p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFileNIOEx {
    public static void main(String[] args) {
        try {
            Charset charset = Charset.forName("utf-8");
            Pattern pattern = Pattern.compile("s\\S");
            File file = new File("C://Users//Admin//Downloads//io_sample.txt");
            FileInputStream stream = null;
            stream = new FileInputStream(file);
            FileChannel channel = stream.getChannel();
            ByteBuffer bytes = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
            CharBuffer chars = charset.decode(bytes);
            Matcher matcher = pattern.matcher(chars);
            if(matcher.find()){
                System.out.println("Found at: "+Integer.toString(matcher.start()));
                System.out.println("value: "+chars.subSequence(matcher.start(),matcher.end()));
            }else{
                System.out.println("not found");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}