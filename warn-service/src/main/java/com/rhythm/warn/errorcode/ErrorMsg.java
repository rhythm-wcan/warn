package com.rhythm.warn.errorcode;

import com.wn.common.exception.LocalError;
import lombok.Data;

/**
 * 项目错误码
 *
 * @author majunjie
 * @date 2018/11/19 13:06
 */
@Data
public class ErrorMsg implements LocalError {

    private String code;

    private String message;

    public ErrorMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorMsg NEW(String code, String message) {
        return new ErrorMsg(code, message);
    }

    public static ErrorMsg NEW(String message) {
        return new ErrorMsg("9999", message);
    }

}
