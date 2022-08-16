package chuong3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {
        List<String> stringList = new LinkedList<>();
        for (String ele : args){
            stringList.add(ele);
        }
        Iterator<String> stringIterator = stringList.listIterator();
        while (stringIterator.hasNext()){
            System.out.println("==============" + stringIterator.next());
        }
    }
}
