package com.zh.aop.aop_args;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/18  22:35
 * @版本：
 */
@Aspect
@Component
public class TrackCounter {
    @Pointcut("execution(* com.zh.aop.aop_args.CompactDisc.* (int)) && args(trackNumber)")
    public void trackPlayed (int trackNumber) {}

    //注意 必须都有参数,而且参数名 参数个数 要相同
    @Before("trackPlayed(trackNumber)")
    public void countTrank (int trackNumber) {
        trackNumber ++ ;


        System.out.println("Before trackNumber" + trackNumber );
    }
}
