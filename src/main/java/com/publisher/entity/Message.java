package com.publisher.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Message {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //формат для сохранения в БД

    private int id;

    private int msisdn;

    private String action;

    private String timestamp;

    public Message() {
    }

    public Message( int msisdn, String action, String timestamp) {
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = timestamp;
    }

    public Message(int id, int msisdn, String action, String timestamp) {
        this.id = id;
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msisdn=" + msisdn +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public Message createMessage(int id) // генерация сообщения
    {
        Random r = new Random();
        Date date = new Date();
        String strDate = dateFormat.format(date);
        int msisdn = r.nextInt(Integer.MAX_VALUE - 1) + 1;
        int i = r.nextInt(2);
        i = 1;
        if (i == 0)
        {
            Message message = new Message(id, msisdn, "PURCHASE", dateFormat.format(date));
            System.out.println(message.toString());
            return message;
        }
        else
        {
            Message message = new Message(id, msisdn, "SUBSCRIPTION", dateFormat.format(date));
            System.out.println(message.toString());
            return message;
        }
    }
}
