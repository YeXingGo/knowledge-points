package com.zh.aop.aop_declateParents;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  23:09
 * @版本：
 */
@Aspect
@Component
public class EncoreableIntroducer {
    //可以直接将 DefaultEncoreable 放入到容器中

    // 这句话可以让 Performance 或子类  实现 Encoreeable ,实现的效果 用  DefaultEncoreable
    // + 代表 是所有子类
    @DeclareParents(value = "com.zh.aop.Performance+",defaultImpl = DefaultEncoreable.class)
    public  Encoreable encoreable;

    //定义切点
    @Pointcut("execution(public * com.zh.aop.Performance.perform(..))")
    public void performace () {}

    // 前置通知
    @Before("performace()")
    public void silenceCellPhones () {
        System.out.println("Silencing cell phones ................");
    }


}
