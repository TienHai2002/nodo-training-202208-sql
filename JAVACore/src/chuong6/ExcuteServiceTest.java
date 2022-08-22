package chuong6;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ExcuteServiceTest {
    public static void main(String[] args) throws Exception {
        PrintNumber number = new PrintNumber();
        Callable<Object> value = Executors.callable(number);
        System.out.println("main say hello");
        value.call();
        System.out.println("main say goodbye");
    }
}
