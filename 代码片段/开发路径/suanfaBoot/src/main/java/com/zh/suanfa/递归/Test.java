package com.zh.suanfa.递归;

/**
 * @描述： TODO 汉罗塔
 * @作者: Light
 * @时间: 2019/12/19  17:04
 * @版本：
 */
public class Test {
    public static void main(String[] args) {
        hanoi(5,'A','B','C');
    }

    /**
     * @param n 	共有N个圈
     * @param A    开始的柱子
     * @param B	中间的柱子
     * @param C	目标的柱子
     * 无论有多少个圈，都认为只有两个。上面的所有圈和最下面一个圈。
     */
    public static void hanoi(int n,char A,char B,char C) {
        //只有一个圈。
        if(n==1) {
            System.out.println("第1个盘子从"+A+"移到"+C);
            //无论有多少个圈，都认为只有两个。上面的所有圈和最下面一个圈。
        }else {
            //移动上面所有的圈到中间位置
            hanoi(n-1,A,C,B);
            //移动下面的圈
            System.out.println("第"+n+"个圈从"+A+"移到"+C);
            //把上面的所有圈从中间位置移到目标位置
            hanoi(n-1,B,A,C);
        }