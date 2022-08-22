package chuong6;

public class DeadLockTest {
    public static void main(String[] args) {
        String[] obj1 = {"obj1","hello"};
        String[] obj2 = {"obj2","xin chao"};
        DeadLockDemo thread1 = new DeadLockDemo(obj1,obj2);
        thread1.setName("thread1");
        DeadLockDemo thread2 = new DeadLockDemo(obj2,obj1);
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }
}