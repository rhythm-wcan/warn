package com.rhythm.warn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *
 *
 * @author majunjie
 * @date 2018/11/21 18:27
 */
@Component
@Aspect
public class RestTimeLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(RestTimeLogAspect.class);

    @Pointcut("execution(* com.*.*.*..*Controller.*(..))")
    private void pointCutMethod() {
    }

    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();

        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("[RESTFUL API] method={}{}{}, use time={}{}", joinPoint.getTarget().getClass(), ".",
                    joinPoint.getSignature().getName(), (end - begin), "ms");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            logger.info("[RESTFUL API] method={}{}{}, use time={}{}, exception={}", joinPoint.getTarget().getClass(),
                    ".", joinPoint.getSignature().getName(), (end - begin), "ms", e.getMessage());
            throw e;
        }
    }

    @Before("pointCutMethod()")
    public void doBefore(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        // 记录下请求内容
        logger.info("[RESTFUL API] URL: {}, ARGS : {}", request.getRequestURI(), Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "pointCutMethod()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("[RESTFUL API] RESPONSE : {}", ret);
    }

}