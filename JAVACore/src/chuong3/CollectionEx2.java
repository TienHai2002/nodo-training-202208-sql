package chuong3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionEx2 {
    public static void main(String[] args) {
        String[] value = {"Tu","An","Hoa","Binh"};
        List<String> stringList = new ArrayList<String>();
        Collections.addAll(stringList,value);
        Collections.sort(stringList);
        for(int i = 0 ; i < value.length;i++){
            System.out.println(stringList.get(i));
        }
        System.out.println();
        System.out.println("vi tri thu " + Collections.binarySearch(stringList,"Hoa"));
    }
}
