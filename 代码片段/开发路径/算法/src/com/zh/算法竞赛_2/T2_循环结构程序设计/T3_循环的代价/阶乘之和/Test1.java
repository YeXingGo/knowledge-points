package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T3_循环的代价.阶乘之和;

import java.util.Scanner;

/**
 * @描述： TODO  计算 s = 1! + 2! + ... + n! (n <= 10 的 6 次方)
 * @作者: Light
 * @时间: 2019/12/2  22:33
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n , s = 0;
        n = scanner.nextInt();
        for (int i = 1; i <= n ; i ++ ) {
            int factorial = 1;
             for (int j = 1; j <= i; j ++) {
                 factorial *= j;

             }
             s = s + factorial;
        }
        System.out.println(s);
    }
}
