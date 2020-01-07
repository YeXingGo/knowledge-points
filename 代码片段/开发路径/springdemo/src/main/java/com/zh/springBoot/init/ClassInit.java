package com.zh.springBoot.init;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/11/6  16:53
 * @版本：
 */
@Component
public class ClassInit implements InitializingBean, DisposableBean {
    public ClassInit() {
        System.out.println("ClassInit 创建............");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("ClassInit afterPropertiesSet ......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("ClassInit destroy............");
    }
    public void test () {
        System.out.println("classInit test ....");
    }

}
