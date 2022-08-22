package chuong6;

public class ThreadTest {
    public static void main(String[] args) {
        PrintMessage message = new PrintMessage("say hello to every one");
        new Thread(message).start();
        new Thread(message).start();
    }
}
