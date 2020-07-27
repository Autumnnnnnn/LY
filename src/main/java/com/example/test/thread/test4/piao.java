package com.example.test.thread.test4;


/**
 * 解决案例出现线程安全问题
 * 1、使用同步代码块
 * synchronized（锁对象）{
 *     //可能有线程安全的代码
 * }
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题：Lock锁
 *      Lock 接口的方法：void lock（）获取锁； void unlock（）释放锁；
 *      java.util.concurrent.locks.ReentrantLock  implement lock 接口
 * 使用步骤：
 *      1、在成员位置创建一个ReentrantLock
 *      2、再可能出现安全问题的代码前后调用lock接口中的方法的lock获取锁
 *      3、再可能出现安全问题的代码前后调用lock接口中的方法的unlock释放锁
 *
 */
public class piao implements Runnable {
    private int p=1000;
    Lock l = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            l.lock();
            if(p>0){
                try {
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"现在正在麦第"+p+"张票");
                    p--;
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    l.unlock();
                }
            }
        }
    }
}
