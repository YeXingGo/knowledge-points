package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T3_3n加1问题;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/1  20:54
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long i = scanner.nextLong();
        int count = 0;
        while (i > 1) {
            if ( i % 2 == 1) {
                i = i * 3 + 1;
            }
            else {
                 i /= 2;
            }
            count ++;
        }
        System.out.println(count);
    }
}
