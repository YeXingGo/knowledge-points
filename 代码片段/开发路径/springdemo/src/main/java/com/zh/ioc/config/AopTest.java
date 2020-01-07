package com.zh.ioc.config;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/14  23:09
 * @版本：
 */
public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("G:\\geren\\ziliao\\个人仓库\\代码片段\\开发路径\\springdemo\\src\\aop.xml");

    }
}
