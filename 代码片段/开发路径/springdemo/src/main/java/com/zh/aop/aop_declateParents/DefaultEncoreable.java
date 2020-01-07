package com.zh.aop.aop_declateParents;

import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  23:20
 * @版本：
 */
//@Component
public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("DefaultEncoreable performEncore");
    }
}
