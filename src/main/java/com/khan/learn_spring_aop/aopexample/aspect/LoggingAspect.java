package com.khan.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before aspect {} - method is called - {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After aspect {} - has executed", joinPoint);
    }

    @AfterThrowing(pointcut = "execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))", throwing = "exception")
    public void logMethodAfterThrowingException(JoinPoint joinPoint, Exception exception) {
        logger.info("After throwing aspect - {} has thrown an exception {}",  joinPoint, exception);
    }

    @AfterReturning(pointcut = "execution(* com.khan.learn_spring_aop.aopexample.*.*.*(..))", returning = "resultValue")
    public void logMethodAfterReturning(JoinPoint joinPoint, Object resultValue) {
        logger.info("After returning aspect - {} has returned {}",  joinPoint, resultValue);
    }
}
