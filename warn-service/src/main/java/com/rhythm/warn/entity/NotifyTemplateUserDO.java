package com.rhythm.warn.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.wn.common.datamodel.BaseDO;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
@TableName("tb_notify_template_user")
public class NotifyTemplateUserDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知模板id
     */
    @TableField("notify_template_id")
    private Long notifyTemplateId;
    /**
     * 通知用户id
     */
    @TableField("notify_user_id")
    private Long notifyUserId;


}
