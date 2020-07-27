package com.example.test.thread.test3Runnable;


/**
 创建多线程的第二种方式，实现Runnable接口：
     Thread（Runnable target） 分配新的Thread对象
     Threab (Runnable target,String name)分配新的Thread对象。

 实现步骤：
     1、创建一个Runnable 接口实现类：
     2、在实现类中重写Runnable接口的run方法，设置线程任务
     3、创建一个Runnable 接口的实现类对象
     4、创建Thread类对象，构造方法中传递Runnable接口的实现类对象
     5、调用Thread类中的start方法
 实现Runnable接口创建多线程程序的好处：
    1、避免了单线程的局限性
        - 一个类只能继承一个类（一个人只能有一个父类），类继承了Thread类就不能继承其他的类；
    2、增强了程序的扩展性，降低了程序的耦合性（解耦）
            实现Runnable 接口的方式，把设置线程任务和开启线程进行了分离（解耦）
            实现类中，重写了run方法：用来设置线程任务
            创建Thread类对象，调用start方法：用来开启线程

 */

public class run {
    public static void main(String[] args) {
        testRunnable s =new testRunnable();
        Thread thread=new Thread(s);
        thread.start();
        for(int i = 0;i<500 ;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
