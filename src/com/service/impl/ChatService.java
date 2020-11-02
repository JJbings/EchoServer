package com.service.impl;

import com.data.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatService extends Thread {
    Message message;

    public ChatService(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String m = null;
            try {
                System.out.println("Input message");
                m = input.readLine();
                message.setMessage(m);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (m.equals("exit")) {
                break;
            }


        }
    }
}
