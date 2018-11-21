package com.rhythm.warn.common.enums;

/**
 * 通知方式实现code
 *
 * @author majunjie
 * @date 2018/11/19 13:03
 */
public enum NotifyImplCodeEnum {

    MAIL("default_mail", NotifyTypeCodeEnum.MAIL.getCode(), "邮件默认实现"),
    PHONE_MSG("default_phone_msg", NotifyTypeCodeEnum.PHONE_MSG.getCode(), "手机短信默认实现"),
    WECHAT("default_wechat", NotifyTypeCodeEnum.WECHAT.getCode(), "微信默认实现"),
    DINGDING("default_dingding", NotifyTypeCodeEnum.DINGDING.getCode(), "钉钉默认实现"),;

    private String code;
    private String typeCode;
    private String name;

    NotifyImplCodeEnum(String code, String typeCode, String name) {
        this.code = code;
        this.typeCode = typeCode;
        this.name = name;
    }

    public static NotifyImplCodeEnum getEnum(String code) {
        for (NotifyImplCodeEnum authCodeEnum : NotifyImplCodeEnum.values()) {
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

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
}
