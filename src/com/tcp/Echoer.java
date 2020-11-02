package com.tcp;

import com.data.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {

    private Socket socket;

    Message message;
    public Echoer(Socket socket, Message message) {
        this.socket = socket;
        this.message=message;

    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Client connected");
            stringToEcho.println("you are connected");
            System.out.println(socket.getChannel());
            while (true){

                String echoString = input.readLine();
                System.out.println(echoString);
                if(!echoString.isEmpty()){
                    stringToEcho.println(echoString);
                }
                message.setMessage(echoString);
                if (echoString.equals("exit")){
                    break;
                }
            }
            System.out.println("client disconnected");
        } catch (IOException e) {
            System.out.println("Client disconnected, "+ e.getMessage());
        }finally {
            try{
                socket.close();
            }catch  (IOException e){

            }
        }
    }
}
