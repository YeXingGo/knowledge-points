package com.zh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/17  23:26
 * @版本：
 */
//@Component
@Aspect
public class Audience {
    //定义切点
    @Pointcut("execution(public * com.zh.aop.Performance.perform(..))")
    public void performace () {}

    // 前置通知
    @Before("performace()")
    public void silenceCellPhones () {
        System.out.println("Silencing cell phones");
    }
    @Before("performace()")
    public void takeSeats () {
        System.out.println("Taking seats");
    }
    @AfterReturning("performace()")
    public void applause () {
        System.out.println("CLAP CLAP CLAP!!!");
    }
    @AfterThrowing ("performace()")
    public void demandRefund () {
        System.out.println("Demanding a refund");
    }

}
