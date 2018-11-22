package com.rhythm.warn.aspect;

import com.rhythm.warn.annotation.LimitRequest;
import com.rhythm.warn.constants.Constant;
import com.wn.common.cache.CachesService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 限流控制
 *
 * @author majunjie
 * @date 2018/11/19 13:07
 */
@Slf4j
@Aspect
@Component
public class LimitRequestAspect {

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private CachesService cachesService;

    @Before("@annotation(limitRequest)")
    public void limitRequest(JoinPoint joinPoint, LimitRequest limitRequest) {
        //获取请求接口地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求路径
        String path = request.getServletPath();
        path = "/" + serviceName + path;
        //请求数+1
        long count = cachesService.incrCounter(Constant.LIMIT_REQUEST, path, 1);
        log.info("请求数计数器：{}", count);
    }

}
