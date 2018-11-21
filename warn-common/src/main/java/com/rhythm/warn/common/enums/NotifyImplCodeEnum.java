package com.rhythm.warn.common.enums;

/**
 * 通知方式实现code
 *
 * @author majunjie
 * @date 2018/11/19 13:03
 */
public enum NotifyImplCodeEnum {

    MAIL("default_mail", "邮件默认实现"),
    PHONE_MSG("default_phone_msg", "手机短信默认实现"),
    WECHAT("default_wechat", "微信默认实现"),
    DINGDING("default_dingding", "钉钉默认实现"),
    ;

    private String code;
    private String remark;

    NotifyImplCodeEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
