package chuong2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ArrayStreamEx {
    public static void main(String[] args) {
        Integer[] values = {2,4,7,1,3,5,9,11,3};
        Arrays.sort(values,(Integer o1, Integer o2 ) -> {
            return o2-o1;
        });
        for (int i = 0 ; i < args.length ;i++){
            Stream<Integer> stream = Arrays.stream(values);
            stream.forEach(value -> System.out.println(value));
            Consumer<Integer> c = (Integer value) -> {
                System.out.println(value);
            };
            stream.forEach(c);
            System.out.println(args[i]);
         Optional<Integer> max = stream.max((Integer o1 , Integer o2) -> {
                return o1-o2;
            });
            System.out.println("gia tri lon nhat = " +max.get());
        }

    }
}
