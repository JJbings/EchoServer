package com.main;

import com.httphandlers.GetHandler;
import com.httphandlers.InfoHandler;
import com.data.Message;
import com.sun.net.httpserver.HttpServer;
import com.tcp.Echoer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {


        try (ServerSocket serverSocket = new ServerSocket(5001, 10)) {


            Message message = new Message();


            HttpServer server2 = HttpServer.create(new InetSocketAddress(8080), 0);

            server2.createContext("/info", new InfoHandler(message));
            server2.createContext("/get", new GetHandler(message));
            server2.setExecutor(null); // creates a default executor
            System.out.println(server2.getAddress());
            server2.start();




            while (true) {
                new Echoer(serverSocket.accept(), message).start();

            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());

        }

    }
}
