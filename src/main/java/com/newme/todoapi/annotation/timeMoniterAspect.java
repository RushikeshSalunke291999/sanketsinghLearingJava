package com.newme.todoapi.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class timeMoniterAspect {

    @Around("@annotation(TimeMoniter)")
    public void logtime(ProceedingJoinPoint joinPoint) {
        System.out.println("logging time");

        long startTime = System.currentTimeMillis();  //start time of code

        try {
            //execute time of joint point--> how --> we see in a min.
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Exception in time" + e.getMessage());
        } finally {
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("total time of Execution : " + totalTime+" ms....");
        }
    }
}
