package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T2_7744问题;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/1  20:24
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        for (int a = 1; a <= 9; a ++) {
            for (int b = 0; b <= 9; b++) {
                int n = a *  1100 + b * 11;
                int m = (int) Math.floor(Math.sqrt(n) + 0.5);
                if (m * m == n) {
                    System.out.print(n +" ");
                }
            }
        }
        System.out.println(Math.sqrt(7744));
        System.out.println(Math.sqrt(7744) + 0.5);
        System.out.println((Math.floor(Math.sqrt(7744) + 0.5)));
        System.out.println((int )(Math.floor(Math.sqrt(7744) + 0.5)));
    }
}
