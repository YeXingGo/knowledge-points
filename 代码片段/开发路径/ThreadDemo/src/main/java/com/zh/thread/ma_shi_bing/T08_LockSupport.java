package com.zh.thread.ma_shi_bing;

import java.util.concurrent.locks.LockSupport;

/**
 * @描述： TODO 使用 LockSupport
 * @作者: Light
 * @时间: 2019/9/24  21:48
 * @版本：
 */
public class T08_LockSupport {
    static Thread t1 = null ;
    static Thread t2 = null ;

    public static void main(String[] args) {

        char [] aI = "1234567".toCharArray();
        char [] aC = "abcdefg".toCharArray();
        t1 = new Thread(() -> {
            for (char a : aI) {
                System.out.print(a);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");
        t2 = new Thread(() -> {
            for (char a : aC) {
                LockSupport.park();
                LockSupport.unpark(t1);
                System.out.print(a);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
