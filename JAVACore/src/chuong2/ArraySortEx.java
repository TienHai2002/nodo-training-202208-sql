package chuong2;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySortEx {
    public static void main(String[] args) {
        Arrays.sort(args);
        for (int i = 0  ; i <args.length;i++){
            System.out.println(args[i]);
        }
        System.out.println("========================");
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0 ; i < args.length ; i++){
            System.out.println(args[i]);
        }
    }
}
