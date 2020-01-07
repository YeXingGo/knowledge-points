package com.zh.注入.testBean;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @描述： TODO 测试@Conditional 可指定环境
 * @作者: Light
 * @时间: 2019/9/16  23:12
 * @版本：
 */
public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        return environment.containsProperty("magic");
    }
}
