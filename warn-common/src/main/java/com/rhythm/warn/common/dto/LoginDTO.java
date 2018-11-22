package com.rhythm.warn.common.dto;

import com.wn.common.datamodel.BaseDTO;
import lombok.Data;

/**
 * 登录dto
 *
 * @author majunjie
 * @since 2018-11-21
 */
@Data
public class LoginDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
