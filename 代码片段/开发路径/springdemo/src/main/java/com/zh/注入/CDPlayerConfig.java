package com.zh.注入;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/15  16:47
 * @版本：
 */
@Configuration
@ComponentScan(value =  {"com.zh"})
@Lazy
public class CDPlayerConfig {

}
