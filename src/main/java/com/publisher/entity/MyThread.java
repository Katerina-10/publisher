package com.publisher.entity;

import com.publisher.Communication;
import com.publisher.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread implements Runnable {
    static int Count = 0; //id сообщения
    private Thread t;
    private String threadName;
    Communication communication;
    static final Object lock1 = new Object();

    public MyThread(String name)  {
        threadName = name;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        communication = context.getBean("communication", Communication.class);
    }

    public void run()  {
        try {
            while (true) { // обработка очереди сообщений
                Message message = new Message();
                synchronized (lock1) {
                    if (communication.saveMess(message.createMessage(Count)))
                    {
                        Count++; // счетчик увеличивается только при успешной отправке собщения
                    }
                }
                Thread.sleep(15000); // ожидание
            }
        } catch (HttpClientErrorException| InterruptedException | IOException e) {
            System.out.println(threadName + " прерван. Exception: " + e.getMessage());
        }
    }

    public void start () {
        if (t == null) {
            t = new Thread ((Runnable) this, threadName);
            t.start ();
        }
    }
}
