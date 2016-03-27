package com.dubianmayou.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 3/27/2016.
 */
@Component
@Aspect
@Order(100)
public class StartAspect {
    @Before("execution(* com.dubianmayou.service.AccountService.*(..))")
    public void logBeforeYou(JoinPoint joinPoint) {
        //can used with JoinPoint how to check with them
        System.out.println("logBefore() is not running!");
    }
//
//    @Around("execution(* com.dubianmayou.service.AccountService.*(..))")
//    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
//        //can used with JoinPoint how to check with them
//        System.out.println("log around startAspect");
//        return joinPoint.proceed();
//    }
}
