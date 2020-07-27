package com.example.test.thread.test2;

public class ThreadDemo {
    public static void main(String[] args) {
        soutT s=new soutT();
        s.start();

        for(int i=0;i<20;i++){
            System.out.println("main"+i);
        }
    }
}
