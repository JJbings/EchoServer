package com.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private String message;

    private String timeStamp;

    public Message() {
        this.message = "Hello World";
        this.timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
