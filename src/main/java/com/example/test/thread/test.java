package com.example.test.thread;

import com.example.test.thread.Tasks;

import java.util.concurrent.*;
public class test {

    public static void main(String[] args) {
        final ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(2,3,60,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(6), Executors.defaultThreadFactory());
        for(int i=0;i<9;i++){
            poolExecutor.execute(new Tasks(i));
        }
        poolExecutor.shutdown();
    }

}
