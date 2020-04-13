package com.zh.suanfa.啊哈_算法.T2_1_栈_队列_链表.队列;

import java.util.Arrays;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/26  9:11
 * @版本：
 */
public class Test1_解密QQ号 {
    public static void main(String[] args) {
        int[]  arry = new int [101];
        int [] arryInit = {0,6,3,1,7,5,8,9,2,4};
        for (int i = 0; i < arryInit.length  ; i++) {
            arry[i] = arryInit[i];
        }
        System.out.println(Arrays.toString(arry));

        int head = 1;
        int tail = 10;
        while (head < tail) {
            System.out.print(arry[head] +" ");
            head ++;
            arry[tail] = arry[head];
            head ++ ;
            tail ++ ;

        }
    }
}
