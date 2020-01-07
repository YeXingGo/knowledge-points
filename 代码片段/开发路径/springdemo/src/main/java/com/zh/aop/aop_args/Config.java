package com.zh.aop.aop_args;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  22:45
 * @版本：
 */
@ComponentScan      // 在测试环境下， 放在测试类中不起作用
@EnableAspectJAutoProxy  //在测试环境下，放在测试类中不起作用 ，必须放在配置类中
public class Config {
}
