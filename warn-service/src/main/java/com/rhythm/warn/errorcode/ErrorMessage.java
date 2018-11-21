package com.rhythm.warn.errorcode;

import lombok.Data;

/**
 * 项目错误码
 *
 * @author majunjie
 * @date 2018/11/19 13:06
 */
@Data
public class ErrorMessage implements CodeAndMessage {

    private String code;

    private String message;

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static ErrorMessage NEW(String code, String message) {
        return new ErrorMessage(code, message);
    }

    public static ErrorMessage NEW(String message) {
        return new ErrorMessage("9999", message);
    }

}
