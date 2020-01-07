package com.zh.mvc.起步;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/22  22:21
 * @版本：
 */
@Configuration
@ComponentScan(basePackages = {"com.zh.mvc.起步"},
        excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,
                value = EnableWebMvc.class)})
public class RootConfig {

}
