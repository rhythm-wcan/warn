package com.rhythm.warn.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wn.common.datamodel.BaseDO;
import lombok.Data;

/**
 * <p>
 * 通知用户账号
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
@TableName("tb_user_account")
public class UserAccountDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 接收通知用户id
     */
    @TableField("notify_user_id")
    private Long notifyUserId;
    /**
     * 通知类型code
     */
    @TableField("notify_code")
    private String notifyCode;
    /**
     * 通知用户账号
     */
    @TableField("user_account")
    private String userAccount;


}
