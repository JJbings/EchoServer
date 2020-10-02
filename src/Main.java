import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {
//        System.out.println("hello world");


        try (ServerSocket serverSocket = new ServerSocket(5001)) {

            while (true) {
                new Echoer(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());

        }

    }
}
