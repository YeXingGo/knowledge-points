package com.zh.thread.ma_shi_bing;

import java.util.concurrent.locks.LockSupport;

/**
 * @描述： TODO  使用 自旋 占用cpu
 * @作者: Light
 * @时间: 2019/9/24  21:54
 * @版本：
 */
public class T06_00_cas {
    enum ReadyToRun {
        T1,T2;
    }

    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char [] aI = "1234567".toCharArray();
        char [] aC = "abcdefg".toCharArray();

         new Thread(() -> {
            for (char a : aI) {
                while (r != ReadyToRun.T1) {

                }
                System.out.print(a);
                r = ReadyToRun.T2;
            }
        },"t1").start();
         new Thread(() -> {
            for (char a : aC) {
                while (r != ReadyToRun.T2) {

                }
                System.out.print(a);
                r = ReadyToRun.T1;
            }
        },"t2").start();
    }
}
