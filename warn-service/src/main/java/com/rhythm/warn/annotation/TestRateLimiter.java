package com.rhythm.warn.annotation;

import java.lang.annotation.*;

/**
 * 接口请求限流
 *
 * @author majunjie
 * @date 2018/11/19 13:06
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestRateLimiter {

}
