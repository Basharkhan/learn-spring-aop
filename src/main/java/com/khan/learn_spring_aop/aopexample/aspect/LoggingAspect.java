package com.khan.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        logger.info("Method {} is called with arguments: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallAfter(JoinPoint joinPoint) {
        logger.info("Method {} has executed", joinPoint.getSignature());
    }
    
    @AfterThrowing(
        pointcut = "execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))",
        throwing = "exception"
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("Method {} has thrown an exception {}", joinPoint.getSignature(), exception.getMessage());
    }

    @AfterReturning(
        pointcut = "execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))",
        returning = "resultValue"
    )
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue) {
        logger.info("Method {} has returned {}", joinPoint.getSignature(), resultValue);
    }
}
