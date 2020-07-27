package com.example.demo.Jl.util;

import java.util.Random;
import java.util.UUID;

public class UUIDUtil {
    private UUIDUtil(){}
    public static String getUuid(){
        Random e = new Random(100);
        String i= String.valueOf(Math.abs(e.nextInt()%10));
        return UUID.randomUUID().toString().replace("-",i);
    }

//    public static void main(String[] args) {
//        System.out.println(UUIDUtil.getUuid());
//        System.out.println(UUIDUtil.getUuid());
//        System.out.println(UUIDUtil.getUuid());
//        System.out.println(UUIDUtil.getUuid());
//    }
}
