package chuong6;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable{
    private String message;

    public PrintMessage(String message) {
        this.message = message;
    }
    public synchronized void run(){
        String[] elements = message.split(" ");
        Arrays.stream(elements).forEach(ele -> {
            System.out.println(Thread.currentThread().getName() + "print" + ele);
            try {
                TimeUnit.SECONDS.sleep(1);
                Thread.sleep((int)(Math.random()*3)*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
