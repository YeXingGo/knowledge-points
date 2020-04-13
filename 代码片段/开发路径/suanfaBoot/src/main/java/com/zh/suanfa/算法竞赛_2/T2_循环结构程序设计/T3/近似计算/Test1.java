package com.zh.suanfa.算法竞赛_2.T2_循环结构程序设计.T3.近似计算;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/1  21:03
 * @版本：
 */
public class Test1 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 0; ; i++) {
            double term = 1.0 / (i * 2 + 1);
            if (i % 2 == 0)
                sum += term;
            else {
                sum -= term;
            }
            if (term < Math.pow(10,-6)) {
                break;
            }

        }
        double pow = Math.pow(10, -6);
        System.out.println(pow);
        System.out.println(sum);
    }
}
