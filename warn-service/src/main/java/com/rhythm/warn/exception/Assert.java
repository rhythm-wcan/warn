package com.rhythm.warn.exception;

import com.rhythm.warn.errorcode.CodeAndMessage;
import org.springframework.util.StringUtils;

/**
 * 断言
 *
 * @author majunjie
 * @date 2018/11/21 16:49
 */
public class Assert {

    public static void isTrue(boolean expression, RuntimeException re) {
        if (!expression) {
            throw re;
        }
    }

    public static void isTrue(boolean expression, CodeAndMessage errorCode) {
        if (!expression) {
            throw new BusinessException(errorCode);
        }
    }

    /**
     * @param obj null 或者 ""
     */
    public static void notEmpty(Object obj, RuntimeException re) {
        if (StringUtils.isEmpty(obj)) {
            throw re;
        }
    }

    public static void notEmpty(Object obj, CodeAndMessage errorCode) {
        if (StringUtils.isEmpty(obj)) {
            throw new BusinessException(errorCode);
        }
    }

    /**
     * @param obj null 或者 "" 或者 " "
     */
    public static void notBlank(Object obj, RuntimeException re) {
        if (obj == null || !StringUtils.hasText(obj.toString())) {
            throw re;
        }
    }

    public static void notBlank(Object obj, CodeAndMessage errorCode) {
        if (obj == null || !StringUtils.hasText(obj.toString())) {
            throw new BusinessException(errorCode);
        }
    }

    public static void notNull(Object obj, RuntimeException re) {
        if (obj == null) {
            throw re;
        }
    }

    public static void notNull(Object obj, CodeAndMessage errorCode) {
        if (obj == null) {
            throw new BusinessException(errorCode);
        }
    }

    public static void isNull(Object obj, RuntimeException re) {
        if (obj != null) {
            throw re;
        }
    }

    public static void isNull(Object obj, CodeAndMessage errorCode) {
        if (obj != null) {
            throw new BusinessException(errorCode);
        }
    }

    public static void isSize(String str, int len, RuntimeException re) {
        if (str == null || str.length() != len) {
            throw re;
        }
    }

    public static void isSize(String str, int len, CodeAndMessage errorCode) {
        if (str == null || str.length() != len) {
            throw new BusinessException(errorCode);
        }
    }

    public static void isSize(String str, int min, int max, RuntimeException re) {
        if (str == null || str.length() < min || str.length() > max) {
            throw re;
        }
    }

    public static void isSize(String str, int min, int max, CodeAndMessage errorCode) {
        if (str == null || str.length() < min || str.length() > max) {
            throw new BusinessException(errorCode);
        }
    }
}
