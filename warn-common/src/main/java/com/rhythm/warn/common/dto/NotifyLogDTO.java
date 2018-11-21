package com.rhythm.warn.common.dto;

import com.wn.common.datamodel.BaseDTO;
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
public class NotifyLogDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知用户名称
     */
    private String notifyUserName;
    /**
     * 通知用户账号
     */
    private String notifyUserAccount;
    /**
     * 通知内容
     */
    private String notifyContent;
    /**
     * 通知方式
     */
    private String notifyTypeName;
    /**
     * 通知方式实现名称
     */
    private String notifyImplName;
    /**
     * 通知方式实现账号名称
     */
    private String notifyAccountName;
    /**
     * 通知结果
     */
    private String result;


}
