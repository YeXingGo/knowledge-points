package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T2_7744问题;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/1  20:39
 * @版本：
 */
public class Test2 {
    public static void main(String[] args) {
        for (int x = 1 ; ; x ++) {
            int n = x * x;
            if (n < 1000) continue;
            if (n > 9999) break;
            int hi = n / 100; // 取出 前两位
            int lo = n % 100; // 取出 后两位
            if (hi / 10  == hi % 10 && lo / 10 == lo % 10) {
                System.out.print(n +" ");
            }
        }
        System.out.println(7744 / 100);
        System.out.println(7744 % 100);
    }
}
