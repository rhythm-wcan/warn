package com.rhythm.warn.common.dto;

import com.wn.common.datamodel.BaseDTO;
import lombok.Data;

/**
 * <p>
 * 通知账号表
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
public class NotifyAccountDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知类型code：邮件(mail)、短信(phone_msg)、微信(wechat)、钉钉(dingding)
     */
    private String notifyCode;
    /**
     * 实现类型code
     */
    private String notifyImplCode;
    /**
     * 账号名称
     */
    private String name;
    private String appKey;
    private String appSecret;
    /**
     * 商户号
     */
    private String merId;
    /**
     * 商户密钥
     */
    private String merSecret;
    /**
     * 账户私钥
     */
    private String privateKey;
    /**
     * 第三方公钥
     */
    private String publicKey;
    /**
     * 状态：-1无效、0初始、1有效
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;


}
