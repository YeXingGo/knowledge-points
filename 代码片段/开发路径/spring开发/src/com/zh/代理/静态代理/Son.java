package com.zh.代理.静态代理;

/**
 * @描述： TODO 儿子
 * @作者: Light
 * @时间: 2019/10/28  23:13
 * @版本：
 */
public class Son implements  Person {
    @Override
    public void findLove() {
        //我没有时间，工作忙
        System.out.println("儿子要求：肤白貌美大长腿");
    }
}
