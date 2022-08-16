package chuong10;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyEx {
    public static void addData(List<Integer> list) {
        while (true) {
            int random = (int) (Math.random() * 100);
            list.add(random);
            System.out.println("add new data " + random);
            try {
                list.forEach(value -> System.out.println("value = " + value));
                Thread.sleep(800);
                System.out.println("==================");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

                throw new RuntimeException(e);
            }
        }

    }

    public static void printData(List<Integer> list) {
        while (true) {
            int random = (int) (Math.random() * 100);
            list.add(random);
            System.out.println("print data: " + random);
            try {
                System.out.println("==================");
                list.forEach(value -> System.out.println("value = " + value));
                Thread.sleep(800);


            } catch (InterruptedException e) {
                e.printStackTrace();


            }
        }

    }

    public static void main(String[] args) {
        ConcurrencyEx concurrencyEx = new ConcurrencyEx();
        List<Integer> list = new ArrayList<>();
        new Thread(() -> addData(list)).start();
        System.out.println("==================");
        new Thread(() -> printData(list)).start();

    }
}
