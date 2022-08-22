import java.io.IOException;
import java.net.*;

public class DatagramClientEx {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[100];
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,4445);
        socket.send(packet);
        packet = new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        System.out.println("Form Sever " + new String(packet.getData(),0, packet.getLength()));
        socket.close();

    }
}
