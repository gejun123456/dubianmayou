package com.dubianmayou.service.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 3/26/2016.
 */
@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.dubianmayou.service.AccountService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        //can used with JoinPoint how to check with them
        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

}
