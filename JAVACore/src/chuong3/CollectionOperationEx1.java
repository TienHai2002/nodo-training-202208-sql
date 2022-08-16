package chuong3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperationEx1 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
        int sum = integerList.stream().reduce(0, (x, y) -> x + y);

        Comparator<Integer> integerComparator = Integer::compare;
        Collections.sort(integerList, integerComparator);
        integerList.stream().filter(v -> v > 5).forEach(v -> {
            System.out.println(v);
        });
        Collector<Integer, ?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics intSummaryStatistics = integerList.stream().collect(collector);
        System.out.println("total = " + intSummaryStatistics.getSum());
        System.out.println("overage = " + intSummaryStatistics.getAverage());

        Consumer<Integer> integerConsumer = n -> {
            System.out.println("user input value = " + n);
            if (n < 5) {
                System.out.println("invalid valued!");
                return;
            }
            integerList.add(n);
            System.out.println("values: ");
            integerList.forEach(x -> {
                System.out.println(x + " - ");
            });
        };
        integerConsumer.accept(12);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("please input a number : ");
            int value = scanner.nextInt();
            integerConsumer.accept(value);

            System.out.println();
            break;
        }
        Predicate<Integer> predicate = v -> v > 5;
        Consumer<Integer> integerConsumer1 = n ->
          integerList.add(n);
          Scanner scanner1 = new Scanner(System.in);
          while (true){
              System.out.println("please input a number: ");
              int value = scanner1.nextInt();
              if (value<0){
                  break;
              }
              if (predicate.test(value)){
                  integerConsumer1.accept(value);
                  break;
              }
          };
          integerList.forEach(x -> {
              System.out.println(x + " - ");
          });


    }
}
