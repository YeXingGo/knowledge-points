package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T4_算法竞赛中的输入输出框架.数据统计1;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/2  22:47
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x , n = 0, min = 1 , max = 1, s = 0;
        while ((x = scanner.nextInt()) != -1 ) {
            s += x;
            if (min > x) {
                min = x;
            }
            if (max < x) {
                max = x;
            }
            n ++ ;
        }
        System.out.println("min = "+ min  +" max ="+max + " avg =" + (double) s / n  );
    }
}
