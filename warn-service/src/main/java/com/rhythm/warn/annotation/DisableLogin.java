package com.rhythm.warn.annotation;

import java.lang.annotation.*;

/**
 * 禁用登录
 *
 * @author majunjie
 * @date 2018/12/3 17:59
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisableLogin {

}
