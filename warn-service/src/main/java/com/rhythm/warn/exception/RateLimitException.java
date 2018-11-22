package com.rhythm.warn.exception;

import com.rhythm.warn.errorcode.CodeAndMessage;

/**
 * 限流异常
 *
 * @author majunjie
 * @date 2018/11/21 16:49
 */
public class RateLimitException extends RuntimeException {

    private static final long serialVersionUID = 5009464957746664524L;

    private final String code;

    private final String DEFAULT_ERROR_CODE = "9999";

    private final String message;

    private final Object[] params;

    public RateLimitException(String message) {
        super();
        this.code = DEFAULT_ERROR_CODE;
        this.message = message;
        this.params = null;
    }

    public RateLimitException(CodeAndMessage errorCode) {
        super();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.params = null;
    }

    public RateLimitException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
        this.params = null;
    }

    public RateLimitException(String code, String message, Object... params) {
        super();
        this.code = code;
        this.message = message;
        this.params = params;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        if (params != null && params.length > 0) {
            return String.format(message, params);
        }
        return message;
    }
}
