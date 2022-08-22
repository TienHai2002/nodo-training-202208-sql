package chuong7p1;

import java.io.*;
import java.util.List;

public class FileOutputEx {
    public static void main(String[] args) throws IOException {
        File file = new File( "C:" + File.separator + "\\Users\\Admin\\Downloads" + File.separator + "hanoijava.txt");
//        FileOutputStream outputStream = null;
////        try {
//            outputStream = new FileOutputStream(file);
//            String bytes =("Hello Ha Noi Class");
//            outputStream.write(bytes.getBytes());
//        } finally {
//            if (outputStream != null){
//                outputStream.close();
//            }
//        }
//        File file = new File ("hanoijava.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
//            byte[] bytes = new byte[16];
            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = fileInputStream.read(bytes)) != -1){
                builder.append(new String(bytes,0,read));
            }
            System.out.println("[" + builder + "]");
            fileInputStream.read(bytes);
            System.out.println(new String(bytes));
            bytes = new byte[124];
            System.out.println("[" + new String(bytes) + "]");

        }

    }
}
