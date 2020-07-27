package com.example.test.thread.test4;

public class maipiao {
    public static void main(String[] args) {
        piao p =new piao();
//        piao2 p =new piao2();
        Thread t1=new Thread(p);
        Thread t2=new Thread(p);
        Thread t3=new Thread(p);

        t1.start();
        t2.start();
        t3.start();

    }
}
