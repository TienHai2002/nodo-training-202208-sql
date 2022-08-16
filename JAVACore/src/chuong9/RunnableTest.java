package chuong9;

public class RunnableTest {
    public static void main(String[] args) {
        //ex1
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+ "say hello class ");
//            }
//        };
//        new Thread(runnable).start();

        //ex2
//        Runnable runnable = () ->{
//            System.out.println(Thread.currentThread().getName()+ "say hello class ");
//        };
//        new Thread(runnable).start();
//       new Thread(() ->  System.out.println(Thread.currentThread().getName()+ "say hello class ")
//               ).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ "say hello class ");
            System.out.println("1 + 1 = " + (1+1));
        }
        ).start();
    }
}
