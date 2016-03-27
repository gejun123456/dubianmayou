package com.dubianmayou.service.aop;


import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by bruce on 3/26/2016.
 */
@Component
@Aspect
@Order(1000)
public class LogAspect {

    private static Gson gson = new Gson();

    @Before("execution(* com.dubianmayou.service.AccountService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        //can used with JoinPoint how to check with them
        System.out.println("logBefore() is running!");
        System.out.println("before : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* com.dubianmayou.service.AccountService.*(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter() is running");
        System.out.println("after:"+joinPoint.getSignature().getName());
        System.out.println("********");
    }

    @AfterThrowing("execution(* com.dubianmayou.service.AccountService.*(..))")

    /***
     * before is before around
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.dubianmayou.service.AccountService.*(..))")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        //can used with JoinPoint how to check with them
        System.out.println("log around LogAspect");
        System.out.println("around : " + joinPoint.getSignature().getName());
        System.out.println(gson.toJson(joinPoint.getArgs()));
        System.out.println("******");
        return joinPoint.proceed();
    }


}
