package com.rhythm.warn.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wn.common.datamodel.BaseDO;
import lombok.Data;

/**
 * <p>
 * 通知日志
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
@TableName("tb_notify_log")
public class NotifyLogDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知用户名称
     */
    @TableField("notify_user_name")
    private String notifyUserName;
    /**
     * 通知用户账号
     */
    @TableField("notify_user_account")
    private String notifyUserAccount;
    /**
     * 通知内容
     */
    @TableField("notify_content")
    private String notifyContent;
    /**
     * 通知方式
     */
    @TableField("notify_type_name")
    private String notifyTypeName;
    /**
     * 通知方式实现名称
     */
    @TableField("notify_impl_name")
    private String notifyImplName;
    /**
     * 通知方式实现账号名称
     */
    @TableField("notify_account_name")
    private String notifyAccountName;
    /**
     * 通知结果
     */
    private String result;


}
