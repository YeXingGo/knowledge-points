package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T5_注解与习题.C6_排列;

import java.util.Scanner;


/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/4  23:07
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        test(n);
        System.out.println();
        test1(n);
    }

    // 通过修改 输出语句
    private static void test(int n) {
        for  (int i = 1;i <= n; i ++) {
            System.out.print(i * 2 +" ");
        }
    }
    // 通过修改 循环条件
    private static void test1(int n) {
        for  (int i = 2;i <= 2 * n; i += 2) {
            System.out.print(i  +" ");
       