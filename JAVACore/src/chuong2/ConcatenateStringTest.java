package chuong2;

import java.sql.Date;

public class ConcatenateStringTest {
    public static void main(String[] args) {
        int max = 1000;
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
         start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            builder.append(String.valueOf(i));
        }

        System.out.println("time 1 = " + (System.currentTimeMillis() - start));

        StringBuffer buffer = new StringBuffer();
         start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            buffer.append(String.valueOf(i));
        }
        System.out.println("time 2 = " + (System.currentTimeMillis() - start));
        String text = "";
         start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            text += String.valueOf(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time 3 = " + (end - start));
    }
}
