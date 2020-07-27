package com.example.test.thread.example;

public class Demo {
    public static void main(String[] args) {
        BC bc=new BC();
        XC xc=new XC();
        new Custom(xc,bc).start();
        new BaoZiPu(xc,bc).start();
    }
}
