package com.zh.aop.aop_declateParents;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  23:23
 * @版本：
 */
@Configuration
@ComponentScan("com.zh.aop")
@EnableAspectJAutoProxy  // 开启注解驱动的切面
public class Config_1 {
}
