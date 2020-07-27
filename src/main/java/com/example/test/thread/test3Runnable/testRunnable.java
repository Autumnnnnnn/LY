package com.example.test.thread.test3Runnable;


public class testRunnable implements Runnable {
    @Override
    public void run() {
        for(int i = 0;i<500 ;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
