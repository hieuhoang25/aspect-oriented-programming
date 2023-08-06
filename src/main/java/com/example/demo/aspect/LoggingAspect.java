package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // Define the pointcut for methods annotated with @Log
    @Pointcut("@annotation(Log)")
    public void logPointcut() {
        System.out.println("Pointcut log");
    }

    // Advice to log all method calls
    @Before("logPointcut()")
    public void logAllMethodCallsAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Executing method in service: " + methodName);
    }
    @Before("execution(* com.example.demo.controller.HomeController.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Endpoint - method: " + methodName);
    }
}
