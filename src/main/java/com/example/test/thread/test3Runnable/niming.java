package com.example.test.thread.test3Runnable;

public class niming {
    public static void main(String[] args) {
        /**
         * 线程的父类是Thread
         * new MyThread().start();
         */
        new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<500 ;i++){
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                }
            }
        }.start();
        /**
         * 线程接口是Runnable
         * Runnable r = new Runnable();//多态
         */
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0;i<500 ;i++){
                    System.out.println(Thread.currentThread().getName()+"--->"+i);
                }
            }
        }).start();
    }
}
