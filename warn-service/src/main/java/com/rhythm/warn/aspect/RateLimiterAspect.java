package com.rhythm.warn.aspect;

import com.google.common.util.concurrent.RateLimiter;
import com.rhythm.warn.annotation.TestRateLimiter;
import com.rhythm.warn.errorcode.ErrorMessage;
import com.rhythm.warn.exception.Assert;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 限流控制
 *
 * @author majunjie
 * @date 2018/11/19 13:07
 */
@Slf4j
@Aspect
@Component
public class RateLimiterAspect {

    @Value("${spring.application.name}")
    private String serviceName;

    private RateLimiter rateLimiter = RateLimiter.create(60);

    @Before("@annotation(testRateLimiter)")
    public void getToken(JoinPoint joinPoint, TestRateLimiter testRateLimiter) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
        if (!rateLimiter.tryAcquire()) {
            log.info("服务器繁忙");
        }
//        Assert.isTrue(rateLimiter.tryAcquire(), ErrorMessage.NEW("服务器繁忙"));
    }

}
