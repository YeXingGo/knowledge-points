package com.zh.suanfa.啊哈_算法.T2_1_栈_队列_链表.栈;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/26  9:41
 * @版本：
 */
public class Test2_解密回文 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] a = new String[101];
        String [] s = new String[101];
        String s1 = sc.nextLine();
        a = s1.split("");
        System.out.println(Arrays.toString(a));
        int len = a.length;
        // 求出中间值
        int mid = (len / 2) - 1;
        // 栈帧
        int top = 0;
        for (int i = 0; i <= mid ; i ++) {
            s [++top] = a [i];
        }
        int next = 0;
        // 偶数
        if (len % 2 == 0) {
            next = mid + 1;
        }
        else {
            next = mid + 2;
        }
        for (int i = next; i <= a.length-1 ; i ++) {
            if (!a[i].equals(s[top] )) {
                break;
            }
            top --;
        }
        if (top == 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("NO");
        }
    }

}
