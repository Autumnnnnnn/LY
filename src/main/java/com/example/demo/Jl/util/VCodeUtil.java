package com.example.demo.Jl.util;

import java.util.Random;

/**
 * @author Nuisance
 * @date 2020/7/23 16:10
 * 验证码获取
 */
public class VCodeUtil {
    public static String getVCode(){
        String VCode = "";
        int p;
        Random random=new Random();
        for (int i = 0; i < 4; i++) {
            p=random.nextInt()%91;
            while(p<65){
                p=random.nextInt()%91;
            }
            VCode=VCode+(char)p;
        }
        return VCode;
    }

//    public static void main(String[] args) {
//        String s = "acDe";
//        System.out.println(s.toUpperCase());
//        System.out.println(VCodeUtil.getVCode());
//    }
}
