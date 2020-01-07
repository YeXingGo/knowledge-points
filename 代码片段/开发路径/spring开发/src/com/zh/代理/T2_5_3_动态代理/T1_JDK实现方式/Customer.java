package com.zh.代理.T2_5_3_动态代理.T1_JDK实现方式;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/12/1  19:58
 * @版本：
 */
public class Customer implements Person {

    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高 180 cm");
        System.out.println("有6块腹肌");
    }
}
