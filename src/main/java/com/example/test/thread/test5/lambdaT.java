package com.example.test.thread.test5;

public class lambdaT {
    public static void main(String[] args) {
        //使用匿名内部类的方式，实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了");
            }
        }).start();
        //使用lambda表达式，实现多线程
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"新线程创建了");
        }).start();
    }
}
