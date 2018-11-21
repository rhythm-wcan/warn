package com.rhythm.warn.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.wn.common.datamodel.BaseDO;
import lombok.Data;

/**
 * <p>
 * 通知用户对象
 * </p>
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
@TableName("tb_notify_user")
public class NotifyUserDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 接收通知用户名称
     */
    private String name;
    /**
     * 状态：-1无效、0初始、1有效
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;


}
