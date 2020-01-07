package com.zh.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  0:29
 * @版本：
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {
  /*  @Bean
    public Audience getAudience () {
        return  new Audience();
    }*/
}
