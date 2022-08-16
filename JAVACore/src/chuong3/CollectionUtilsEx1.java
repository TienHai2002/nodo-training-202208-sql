package chuong3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtilsEx1 {
    public static void main(String[] args) {
        Short[] value = {1,2,3,4,5,6,7,8,9};
        List<Short> shortList = new ArrayList<>();
        Collections.addAll(shortList,value);
        Collections.reverse(shortList);
        shortList.toArray(value);
        for (int i = 0 ; i< shortList.size();i++){
            System.out.println(value[i] + " , ");
        }
    }
}
