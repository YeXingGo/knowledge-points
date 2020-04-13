package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T5_注解与习题.C3_倒三角;

import java.util.Scanner;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/3  23:10
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pre = 0;
        int n = scanner.nextInt();
        int count  = n * 2 -1;
        for (;n > 0 ; n --) {
            pre =  2 * n -1;
            for (int i = 1; i <= (( count - pre) / 2); i ++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= pre  ; i++) {

                System.out.print("#");
            }
            for (int i = 1; i <= (( count - pre) / 2); i ++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
