import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerEx {
    public SocketServerEx() {
        try {
            ServerSocket serverSocket = new ServerSocket(9425);
            System.out.println("SERVER Listening : ...");
            System.out.println("==============================");
            System.out.println("Client Start : ...");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try (DataInputStream input = new DataInputStream(socket.getInputStream());
                         DataOutputStream output = (DataOutputStream) socket.getOutputStream()) {
                        System.out.println("client say " + input.readUTF());
                        output.writeUTF("I AM GROOOOOOOOOOT");
                        System.out.println("============================");
                        output.writeUTF("hello sever : ");
                        System.out.println("Sever Say " + input.readUTF());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9425);
    }
}
