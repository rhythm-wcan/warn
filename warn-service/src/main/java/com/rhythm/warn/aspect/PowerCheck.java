package com.rhythm.warn.aspect;

import java.lang.annotation.*;

/**
 * 权限拦截
 *
 * @author majunjie
 * @date 2018/11/19 13:06
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PowerCheck {

}
