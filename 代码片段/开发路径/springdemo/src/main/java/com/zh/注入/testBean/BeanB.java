package com.zh.注入.testBean;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/15  23:13
 * @版本：
 */
public class BeanB {
    private BeanA beanA;

    public BeanB(BeanA beanA) {
        System.out.println("BeanB .............");
        this.beanA = beanA;
    }
}
