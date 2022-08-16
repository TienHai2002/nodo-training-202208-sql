package chuong2;

import java.util.stream.IntStream;

public class IntStreamEx2 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("nodo-tranning");
        IntStream stream = IntStream.range(0,10);
        stream.forEach(value -> {
            if (builder.length() > 0){
                builder.append(" , ");
                builder.append(value);
            }
        });
        System.out.println("Text value : " + builder);
    }
}
