package com.rhythm.warn.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wn.common.datamodel.BaseDO;
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
@TableName("tb_notify_template")
public class NotifyTemplateDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 模板名称
     */
    private String name;
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
     * 发起通知账号id
     */
    @TableField("notify_account_id")
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
