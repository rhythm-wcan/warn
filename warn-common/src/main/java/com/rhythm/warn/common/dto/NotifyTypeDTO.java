package com.rhythm.warn.common.dto;

import lombok.Data;

/**
 * <p>
 * 通知方式表
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
public class NotifyTypeDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知类型名称
     */
    private String name;
    /**
     * 通知类型code：邮件(mail)、短信(phone_msg)、微信(wechat)、钉钉(dingding)
     */
    private String notifyCode;

}
