package com.rhythm.warn.common.enums;

/**
 * demo
 *
 * @author majunjie
 * @date 2018/811/19 13:03
 */
public enum DemoEnum {

    DEMO("demo", "样例"),
    ;

    private String code;
    private String remark;

    DemoEnum(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public static DemoEnum getEnum(String code) {
        for (DemoEnum authCodeEnum : DemoEnum.values()) {
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
