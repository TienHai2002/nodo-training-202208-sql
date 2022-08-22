package chuong6;

import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) throws InterruptedException {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("TienHaIsMe");
        thread.start();


        Thread thread1 = new Thread(number);
        thread1.setName("TienHaIsMe1");
        thread1.start();

        Thread thread2 = new Thread(number);
        thread2.setName("TienHaIsMe2");
        thread2.start();
        thread.setDaemon(true);
        Thread.currentThread().join();
        System.out.println("Main Thread Hello");
        System.out.println("Main Thread Goodbye");
        while (thread.isAlive()) {
            if (number.getNumber() % 10 == 0) {
                number.setAlive(false);
                TimeUnit.SECONDS.sleep(1);
//                Thread.sleep(1000);

            }
            break;
        }
    }
}
