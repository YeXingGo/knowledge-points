package com.zh.thread.ma_shi_bing;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @描述： TODO 利用了 BlockingQueue的阻塞
 * @作者: Light
 * @时间: 2019/9/24  22:12
 * @版本：
 */
public class T09_00_BlockingQueue {
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<String>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<String>(1);

    public static void main(String[] args) {
        char [] aI = "1234567".toCharArray();
        char [] aC = "abcdefg".toCharArray();

        new Thread (() -> {
            for (char a : aI) {
                System.out.print(a);
                try {
                    q1.put("ok");
                    //从 q2 中 拿取一个值，如果没有值进入阻塞状态
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
        new Thread (() -> {
            for (char a : aC) {
                try {
                    q1.take();
                    System.out.print(a);
                    q2.put("ok");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}
