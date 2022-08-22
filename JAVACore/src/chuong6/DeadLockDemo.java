package chuong6;

import java.util.Arrays;

public class DeadLockDemo extends Thread{

    private String[] lock1;
    private String[] lock2;


    public DeadLockDemo(String[] lock1, String[] lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        Thread thread = new Thread();
        synchronized (lock1){
            System.out.println(thread.getName()+":Holding"+ Arrays.toString(lock1) +"...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(thread.getName()+"----->"+Arrays.toString(lock1)+":"+Arrays.toString(lock2)+"...");

            Thread thread2 = new Thread();
            System.out.println(thread2.getName()+":waiting for"+Arrays.toString(lock2)+"...");
            synchronized (lock2){
                try {Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(thread2.getName()+"----->"+Arrays.toString(lock1)+":"+Arrays.toString(lock2)+"...");
            }
        }
    }
}