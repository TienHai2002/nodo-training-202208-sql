package chuong3;

import java.util.Set;
import java.util.TreeSet;

public class SetEx {
    public static void main(String[] args) {
        Set<Integer> integerSetNumbers = new TreeSet<Integer>();
        integerSetNumbers.add(1);
        integerSetNumbers.add(14);
        integerSetNumbers.add(8);
        integerSetNumbers.add(3);
        integerSetNumbers.add(12);
        integerSetNumbers.add(8);

        System.out.println("Size of set : " + integerSetNumbers.size());
    }
}
