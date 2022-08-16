package chuong3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx2 {
    public static void main(String[] args) {
        List<String> stringList = new LinkedList<>(Arrays.asList(args));
        stringList.forEach(value->{
            System.out.println(value);
        });
    }
}
