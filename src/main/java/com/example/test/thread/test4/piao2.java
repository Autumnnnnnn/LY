package com.example.test.thread.test4;

public class piao2 implements Runnable {
    private int p=1000;
    @Override
    public void run() {
        while (true){
            payTicket();
        }
    }

    //锁对象就是 this 当前线程
    private  synchronized void payTicket() {
        if(p>0){
            System.out.println(Thread.currentThread().getName()+"现在正在麦第"+p+"张票");
            p--;
        }
    }
}
