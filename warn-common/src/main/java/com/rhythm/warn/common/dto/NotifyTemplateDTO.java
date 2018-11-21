package com.rhythm.warn.common.dto;

import com.wn.common.datamodel.BaseDTO;
import lombok.Data;

/**
 * <p>
 * 通知模板表
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
public class NotifyTemplateDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 模板名称
     */
    private String name;
    /**
     * 通知类型code：邮件(mail)、短信(phone_msg)、微信(wechat)、钉钉(dingding)
     */
    private String notifyCode;
    /**
     * 实现类型code
     */
    private String notifyImplCode;
    /**
     * 发起通知账号id
     */
    private Long notifyAccountId;
    /**
     * 通知内容
     */
    private String content;
    /**
     * 状态：-1无效、0初始、1有效
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;


}
