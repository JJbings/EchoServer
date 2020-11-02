package com.httphandlers;

import com.data.Message;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.*;

 public class GetHandler implements HttpHandler {
    private Message message;

    public GetHandler(Message message) {
        this.message = message;
    }

    public void handle(HttpExchange t) throws IOException {
        String response = message.getMessage() + " -------  " + message.getTimeStamp();
        Headers h = t.getResponseHeaders();
        h.add("Access-Control-Allow-Origin", "*");
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();

        os.write(response.getBytes());
        os.close();
    }
}

