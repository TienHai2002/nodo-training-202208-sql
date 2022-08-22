package chuong6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FeatureExTest {
    public static void main(String[] args) {
        try {
            CallableSample callableSample = new CallableSample();
            System.out.println("----------------");
            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(callableSample);
            System.out.println("future done? "+future.isDone());
            Integer result =future.get(1, TimeUnit.SECONDS);
//            System.out.println("Future done?"+future.isDone()+"-result= "+result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
