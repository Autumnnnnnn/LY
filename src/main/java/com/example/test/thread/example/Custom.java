package com.example.test.thread.example;

import java.util.Random;

public class Custom extends Thread {
    public XC xc;
    public BC bc;
    public Custom(XC xc,BC bc){
        this.xc=xc;
        this.bc=bc;
    }
    @Override
    public void run() {
        int count;
        while (true){
                if (System.currentTimeMillis()%2==0){
                    //吃香菜包子
                    System.out.println(Thread.currentThread().getName()+"想吃香菜包子");
                    synchronized (xc) {
                        if (xc.XCbz < 1) {
                            //没香菜包子了，进入等待，
                            try {
                                xc.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //唤醒后
                        try {
                            Thread.sleep(3000);
                            System.out.println(Thread.currentThread().getName() + "吃完了香菜包子");
                            xc.XCbz--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + "想吃白菜包子");
                    synchronized (bc) {
                        if (bc.BCbz < 1) {
                            //没白菜包子了，进入等待，
                            try {
                                bc.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //唤醒后
                        try {
                            Thread.sleep(3000);
                            System.out.println(Thread.currentThread().getName() + "吃完了白菜包子");
                            bc.BCbz--;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

        }
}
