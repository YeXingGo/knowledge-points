package com.zh.thread.ma_shi_bing;

/**
 * @描述： TODO 使用 wait 和 notify, 必须和 锁一起使用
 * @作者: Light
 * @时间: 2019/9/25  9:21
 * @版本：
 */
public class T02_00_sync_wait_notify {
    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "abcdefg".toCharArray();
        Object o = new Object();
        new Thread(() -> {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                for (char a : aI) {
                    System.out.print(a);
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();   //让另一个线程关闭 ，因为 wait 会等待
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char a : aC) {

                    try {
                        o.notify();
                        o.wait();
                        System.out.print(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }
        }, "t2").start();
    }
}
