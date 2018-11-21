package com.rhythm.warn.errorcode;

import com.wn.common.exception.LocalError;

/**
 * 项目错误码
 *
 * @author majunjie
 * @date 2018/11/19 13:06
 */
public enum ErrorCode implements LocalError {
    PARAM_DATA_NULL(10001, "请求数据为空"),

    ;

    private int code;

    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code + "";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
