package chuong3;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        TreeMap<Integer,String> integerStringTreeMap = new TreeMap<Integer, String>();
        integerStringTreeMap.put(3,"Nguyen Van A");
        integerStringTreeMap.put(5,"Nguyen Van B");
        integerStringTreeMap.put(4,"Nguyen Van C");
        integerStringTreeMap.put(1,"Nguyen Van X");
        Iterator<Map.Entry<Integer,String>> entryIterator = integerStringTreeMap.entrySet().iterator();
//        while (entryIterator.hasNext()){
//            Map.Entry<Integer,String> integerStringEntry = entryIterator.next();
//            System.out.println(integerStringEntry.getKey() + " : " + integerStringEntry.getValue());
//        }
        integerStringTreeMap.descendingKeySet().forEach(key ->{
            System.out.println("key = " + key + " value = " + integerStringTreeMap.get(key));
        });
    }

}
