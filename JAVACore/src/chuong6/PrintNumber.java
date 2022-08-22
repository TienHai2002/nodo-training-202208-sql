package chuong6;

import java.util.Arrays;

public class PrintNumber implements Runnable {
    private int number = 1;
    private Integer number1 = new Integer(1);
    private boolean alive = true;

    public PrintNumber(int number, boolean alive) {
        this.number = number;
        this.alive = alive;
    }

    public PrintNumber() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    //    public void run(){
//        Thread current = Thread.currentThread();
//        while (alive){
//            number++;
//            System.out.println(current.getName() + " number is \'" + number + "\'");
//            try {
//                Thread.sleep(800);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//
//            }
//            System.out.println(current.getName() + "is stopted");
//            break;
//        }
//    }
//public void run(){
//        Thread current = Thread.currentThread();
//        while (number < 10){
//            number++;
//            System.out.println(current.getName() + " number is \'" + number + "\'");
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//
//            }
//            System.out.println(current.getName() + "is stopted");
//            break;
//        }
//    }
//    public void run() {
//        Thread current = Thread.currentThread();
//
//        while (number1 < 30) {
//            number1++;
//            System.out.println(current.getName() + " number is \'" + number1 + "\'");
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//
//            }
//            System.out.println(current.getName() + "is stopted");
//            break;
//
//        }
//    }

    public void run() {
        Thread current = Thread.currentThread();
        while (number<30){
            number++;
            try {
                System.out.println(current.getName()+"number is\""+number+"\"");
                Thread.sleep(300);
                if (number%10==0){
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(current.getName()+"is stopped");
    }
}