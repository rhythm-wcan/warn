package com.rhythm.warn.common.enums;

/**
 * 通知方式code
 *
 * @author majunjie
 * @date 2018/11/19 13:03
 */
public enum NotifyTypeCodeEnum {

    MAIL("mail", "邮件"),
    PHONE_MSG("phone_msg", "手机短信"),
    WECHAT("wechat", "微信"),
    DINGDING("dingding", "钉钉"),
    ;

    private String code;
    private String name;

    NotifyTypeCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static NotifyTypeCodeEnum getEnum(String code) {
        for (NotifyTypeCodeEnum authCodeEnum : NotifyTypeCodeEnum.values()) {
            if (authCodeEnum.getCode().equals(code)) {
                return authCodeEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
