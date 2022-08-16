package chuong3;

import java.util.Hashtable;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        Map<Integer,String> integerStringMap = new Hashtable<Integer, String>();
        integerStringMap.put(3,"Nguyen Van A");
        integerStringMap.put(3,"Nguyen Van B");
        integerStringMap.put(3,"Nguyen Van C");
        integerStringMap.put(3,"Nguyen Van X");

        System.out.println(integerStringMap.get(3));

        integerStringMap.put(3,"Nguyen Thi A");
        System.out.println(integerStringMap.get(3));
    }
}
