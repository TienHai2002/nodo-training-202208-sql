import java.io.IOException;
import java.net.*;

public class DatagramSeverEx implements Runnable {
    public DatagramSeverEx() {
        try {
            DatagramSocket socket = new DatagramSocket(4445);
            System.out.println("DATA SEVER Listening ........");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        byte[] bytes = new byte[100];
        DatagramSocket socket = null;
        try {
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket = new DatagramSocket();
            socket.receive(packet);
            System.out.println("From Client " + new String(packet.getData(), 0, packet.getLength()));
            byte[] byte1 = "sever say hello".getBytes();
            socket.send(new DatagramPacket(byte1, byte1.length, packet.getAddress(), packet.getPort()));
        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            socket.close();
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                new DatagramSeverEx();
            }
        };
        thread.start();
    }
}
