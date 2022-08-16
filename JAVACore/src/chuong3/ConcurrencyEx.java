package chuong3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyEx {
    public static void main(String[] args) {
        Integer[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> integerList = new ArrayList<Integer>();
        Collections.addAll(integerList, value);
        System.out.println("Before remove : size of list = " + integerList.size());
        //ex1
//        for (int i = 0 ; i < integerList.size(); i++){
//            if (integerList.get(i) == 3 ){
//                integerList.remove(i);
//            }
//            System.out.println("After remove size of list = " + integerList.size());
//        }
        //ex2
//        integerList.forEach(v -> {
//            if (v == 3) {
//                integerList.remove(v);
//            }
//        });
//        System.out.println("After remove size of list = " + integerList.size());
//    }
        //ex3
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
            break;
        }
      integerList.removeIf(item ->{
          return item ==3;
      });
        integerList.removeAll(Collections.singleton(3));
    }
}
