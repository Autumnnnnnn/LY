package com.example.test.thread.test2;

public class soutT extends Thread {
    @Override
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println("run"+i);
        }
    }
}
