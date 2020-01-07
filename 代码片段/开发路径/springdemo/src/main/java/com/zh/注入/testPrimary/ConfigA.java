package com.zh.注入.testPrimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/16  23:41
 * @版本：
 */
@Configuration
@ComponentScan
//TODO 注意除java文件其他配置文件只能放在resources目录下面
@PropertySource("classpath:\\app.properties")
public class ConfigA {
    @Autowired
    Environment env;

    @Primary
    @Bean
    public A1 getA1 ()  {
        //带有两个参数表示 如果没有 该字段 ，则使用 默认值 231213
        String name = env.getProperty("name","231213");
        System.out.println(name);
        return new A1();
    }
    /*@Primary
    @Bean
    public A2 getA2 () {
        return new A2();
    }*/
}
