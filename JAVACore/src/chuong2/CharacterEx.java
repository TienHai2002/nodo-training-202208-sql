package chuong2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterEx {
    private static int countDigit(String value){

       int i = 0;
      int  counter = 0;

        while (i<value.length()){
            char c = value.charAt(i);
            if(Character.isDigit(c)){
                counter++;
                i++;
            }
        }
        return counter;
    }
    private static int countDigit1(String value){
        AtomicInteger counter1 = new AtomicInteger(0);
        IntStream stream = value.chars();

        stream.forEach( c -> {
            if (Character.isDigit(c)){
                counter1.incrementAndGet();
            }

        });
        return counter1.get();
    }
    public static void main(String[] args) {
        System.out.println("There are " + countDigit(args[0]) + "digit in the text");
        //plese modify your coode to count white space in thext
    }
}
