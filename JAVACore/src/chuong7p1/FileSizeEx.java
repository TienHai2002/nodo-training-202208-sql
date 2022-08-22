package chuong7p1;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeEx {
    private static long getSize(File file) {
        if (file.isFile()) {
            return file.length();

        }
        File[] files = file.listFiles();
        AtomicLong lengths = new AtomicLong(0);
        Arrays.stream(file.listFiles()).forEach(f -> {
            lengths.getAndSet(lengths.longValue() + (f.isFile() ? getSize(f) : f.length()));
        });
        return lengths.longValue();
//        int length = 0;
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isFile()) {
//                length += getSize(files[i]);
//                continue;
//            }
//            length += files[i].length();
//        }
//
//
//        return length;

    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Admin\\Downloads");
        System.out.println("Size " + getSize(file) / (1024 * 1024) + "MB");

    }
}
