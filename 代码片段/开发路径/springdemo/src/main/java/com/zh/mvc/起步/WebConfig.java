package com.zh.mvc.起步;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/22  22:11
 * @版本：
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.zh.mvc.起步")
public class WebConfig
    extends WebMvcConfigurerAdapter {

    /* @Author Light
     * @Description //TODO  配置JSP视图解析器
     * @Date 22:16 2019/9/22
     * @Param
     * @return
     **/
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/VIEW");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /* @Author Light
     * @Description //TODO 配置静态资源的处理
     * @Date 22:16 2019/9/22
     * @Param
     * @return
     **/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //使用默认Servlet 处理 静态资源
        configurer.enable();
    }
}
