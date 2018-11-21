package com.rhythm.warn.common.dto;

import com.wn.common.datamodel.BaseDTO;
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
public class NotifyTemplateUserDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 通知模板id
     */
    private Long notifyTemplateId;
    /**
     * 通知用户id
     */
    private Long notifyUserId;


}
