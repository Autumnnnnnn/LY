package com.example.test.thread.test4;

public class wxdd {
    public static void main(String[] args) {
        Object obj=new Object();

        //消费者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                synchronized (obj){
                    System.out.println("告诉老板要吃的包子种类数量");
                    //调用wait()方法，放弃cpu的执行，进入到waiting（无限等待）
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒后执行
                    System.out.println("包子已经做好了，可以吃了！");
                }
            }
        }).start();

        //生产者线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 花时间做包子
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println("老板做好包子后，告知顾客可以吃啦！");
                    //做好包子后调用 notify（）方法 唤醒顾客吃包子；
                    obj.notify();
                }
            }
        }).start();
    }
}
