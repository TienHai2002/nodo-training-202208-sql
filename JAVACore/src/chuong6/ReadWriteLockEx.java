package chuong6;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockEx {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        HashMap map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        executor.submit(() ->{
            System.out.println("start write");
            lock.writeLock().lock();
            try {
                TimeUnit.SECONDS.sleep(10);
            map.put("foo",map);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.writeLock().unlock();
                System.out.println("end witing");
            }
        });
        Runnable readTask = () -> {
            System.out.println("start reading");
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
            }finally {
                lock.writeLock().unlock();
                System.out.println("end reading");
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);
    }
}
