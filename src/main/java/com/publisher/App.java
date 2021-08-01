package com.publisher;

import com.publisher.entity.MyThread;
import java.io.IOException;

public class App
{
    public static void main ( String[] args ) throws InterruptedException, IOException {
        MyThread R1 = new MyThread( "Поток-1");
        R1.start();
        MyThread R2 = new MyThread( "Поток-2");
        R2.start();
        MyThread R3 = new MyThread( "Поток-3");
        R3.start();
        MyThread R4 = new MyThread( "Поток-4");
        R4.start();
        MyThread R5 = new MyThread( "Поток-5");
        R5.start();
    }
}