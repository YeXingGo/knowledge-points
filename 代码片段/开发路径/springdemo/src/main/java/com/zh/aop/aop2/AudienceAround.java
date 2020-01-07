package com.zh.aop.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO 测试环绕 通知
 * @作者: Light
 * @时间: 2019/9/18  22:17
 * @版本：
 */
@Aspect
//@Component
public class AudienceAround {
    //看出 切点的方法可以带有 其他返回类型的
    /*@Pointcut("execution(* com.zh.aop.Performance.* (..))")
    public String performance () {
        return "";
    }*/
    @Pointcut("execution(* com.zh.aop.Performance.* (..))")
    public void performance () {
    }
    @Around("performance()")  // 只有 环绕通知中才可以使用 ProceedingJoinPoint对象
    public void watchPerformance (ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            joinPoint.proceed();
            System.out.println("CLAP CLAP CLAP!!! 12345465");
        }
        catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
