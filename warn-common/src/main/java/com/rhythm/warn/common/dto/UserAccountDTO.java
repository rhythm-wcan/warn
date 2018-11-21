package com.rhythm.warn.common.dto;

import com.wn.common.datamodel.BaseDTO;
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
public class UserAccountDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 接收通知用户id
     */
    private Long notifyUserId;
    /**
     * 通知类型code
     */
    private String notifyCode;
    /**
     * 通知用户账号
     */
    private String userAccount;


}
