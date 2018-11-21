package com.rhythm.warn.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限校验
 *
 * @author majunjie
 * @date 2018/11/19 13:07
 */
@Slf4j
@Aspect
@Component
public class PowerCheckAspect {

    @Value("${spring.application.name}")
    private String serviceName;

    @Before("@annotation(powerCheck)")
    public void powerCheck(JoinPoint joinPoint, PowerCheck powerCheck) {
        //获取请求接口地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
