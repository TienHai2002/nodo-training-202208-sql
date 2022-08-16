package chuong9;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortEx {
    public static void main(String[] args) {
        Integer[] value = {12,345,34,7,9,12,9};
        Arrays.sort(value, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Arrays.sort(value,(Integer o1,Integer o2) ->{
            return o2-o1;
        });
        for (Integer e : value){
            System.out.println(e + ",");
        }
    }
}
