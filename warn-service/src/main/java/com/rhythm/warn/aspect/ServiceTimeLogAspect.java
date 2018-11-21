package com.rhythm.warn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author majunjie
 * @date 2018/11/21 18:27
 */
@Component
@Aspect
public class ServiceTimeLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTimeLogAspect.class);

    @Pointcut("@annotation(com.rhythm.warn.annotation.ServiceTimeLog)")
    private void pointCutMethod() {
    }

    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("[SERVICE INTERFACE] method={}{}{}, use time={}{}", joinPoint.getTarget().getClass(), ".",
                    joinPoint.getSignature().getName(), (end - begin), "ms");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("[SERVICE INTERFACE] method={}{}{}, use time={}{}, exception={}",
                    joinPoint.getTarget().getClass(), ".", joinPoint.getSignature().getName(), (end - begin), "ms",
                    e.getMessage());
            throw e;
        }
    }

    @Before("pointCutMethod()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录下请求内容
        logger.info("[SERVICE INTERFACE] ARGS : {}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "pointCutMethod()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("[SERVICE INTERFACE] RESPONSE : {}", ret);
    }

}