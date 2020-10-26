import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {



        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/test", new MyHandler());
            System.out.println("Welcome");
            System.out.println(server.getAddress());

            server.setExecutor(null); // creates a default executor
            server.start();
            while (true) {
                new Echoer(serverSocket.accept()).start();

            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());

        }

    }
}
