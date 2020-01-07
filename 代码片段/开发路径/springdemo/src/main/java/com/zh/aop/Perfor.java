package com.zh.aop;

import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  0:30
 * @版本：
 */
@Component
public class Perfor  implements  Performance{
    @Override
    public void perform() {
        System.out.println("perform");
//        int a = 1 /0 ;
    }
}
