package com.example.test.thread.example;
public class BaoZiPu extends Thread {
    public XC xc;
    public BC bc;
    public BaoZiPu(XC xc,BC bc){
        this.xc=xc;
        this.bc=bc;
    }
    @Override
    public void run() {
        while (true){
            if(xc.XCbz>10&&bc.BCbz>10) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                if(bc.BCbz>xc.XCbz) {
                    synchronized (bc) {
                        try {
                            Thread.sleep(1000);
                            bc.BCbz++;
                            System.out.println("做完一个白菜的包子++,/n现在白菜包子有" + bc.BCbz + "个    香菜包子有" + xc.XCbz + "个");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("有白菜包子了，唤醒顾客吃包子了！");
                        bc.notify();
                    }
                }else {
                    synchronized (xc) {
                        try {
                            Thread.sleep(1000);
                            xc.XCbz++;
                            System.out.println("做完一个香菜的包子++,现在白菜包子有" + bc.BCbz + "个    香菜包子有" + xc.XCbz + "个");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("有香菜包子了，唤醒顾客吃包子了！");
                        xc.notify();
                    }
                }
            }
        }//while

    }
}
