package com.zh.注入.testBean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/15  23:14
 * @版本：
 * @Bean
 */
@Configuration
public class BeanConfig {
    /* @Author Light
     * @Description //TODO
     * @Date 23:22 2019/9/15
     * @Param  如果 beanA 对象没有创建 就会先创建，如果有的话直接返回对象，而不会在创建
     * @return
     **/
    @Conditional(MagicExistsCondition.class)
    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public BeanB getBeanB() {
        System.out.println("Conditional..........");
        return new BeanB(getBeanA());
    }
    @Bean
    public BeanA getBeanA() {
        return new BeanA();
    }
    @Bean
    public BeanB getBeanB1 (){
        return new BeanB(getBeanA());
    }
}
