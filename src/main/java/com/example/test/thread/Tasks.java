package com.example.test.thread;


public class Tasks implements Runnable {
    private int i;

    public Tasks(int i){
        this.i=i;
    }
    @Override
    public void run() {
        System.out.println("执行当前任务的线程是："+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是任务"+i+"我在执行");
    }

}
