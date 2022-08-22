package chuong6;

import java.util.Arrays;

public class SimpleThreadSample {
    public static void main(String[] args) {
        new Thread(() -> {
            Arrays.stream(args).forEach(ele -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(ele);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }).start();
    }
}
