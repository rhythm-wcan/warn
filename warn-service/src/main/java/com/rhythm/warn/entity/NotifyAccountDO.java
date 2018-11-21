package com.rhythm.warn.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wn.common.datamodel.BaseDO;
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
@TableName("tb_notify_account")
public class NotifyAccountDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知类型code：邮件(mail)、短信(phone_msg)、微信(wechat)、钉钉(dingding)
     */
    @TableField("notify_code")
    private String notifyCode;
    /**
     * 实现类型code
     */
    @TableField("notify_impl_code")
    private String notifyImplCode;
    /**
     * 账号名称
     */
    private String name;
    @TableField("app_key")
    private String appKey;
    @TableField("app_secret")
    private String appSecret;
    /**
     * 商户号
     */
    @TableField("mer_id")
    private String merId;
    /**
     * 商户密钥
     */
    @TableField("mer_secret")
    private String merSecret;
    /**
     * 账户私钥
     */
    @TableField("private_key")
    private String privateKey;
    /**
     * 第三方公钥
     */
    @TableField("public_key")
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
