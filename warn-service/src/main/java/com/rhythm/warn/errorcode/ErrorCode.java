package com.rhythm.warn.errorcode;

/**
 * 项目错误码
 *
 * @author majunjie
 * @date 2018/11/19 13:06
 */
public enum ErrorCode implements CodeAndMessage{
    PARAM_DATA_NULL(10001, "请求数据为空"),
    INSERT_FAIL(10002, "添加数据失败"),
    UPDATE_FAIL(10003, "修改数据失败"),
    DELETE_FAIL(10004, "删除数据失败"),
    NOTIFY_TYPE_NULL(10005, "通知方式为空"),
    NOTIFY_TYPE_CODE_NULL(10006, "通知方式名称为空"),
    LOGIN_FAIL(10007, "账号密码错误"),
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
