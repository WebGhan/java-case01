package com.gaohan.case01.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect1 {

    // @Pointcut("execution(* com.gaohan.case01.service.DeptService.*(..))")
    @Pointcut("@annotation(com.gaohan.case01.aop.MyLog)")
    public void pt() {}

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before ...");

        // 1. 获取 目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名：{}", className);

        // 2. 获取 目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法的方法名：{}", methodName);

        // 3. 获取 目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数：{}", Arrays.toString(args));

        // 4. 放行 目标方法执行
        Object result = joinPoint.proceed();
        log.info("目标方法运行的返回值：{}", result);

        log.info("around after ...");
        return result;
    }

    @After("pt()")
    public void after() {
        log.info("after ...");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("afterReturning ...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("afterReturning ...");
    }
}
