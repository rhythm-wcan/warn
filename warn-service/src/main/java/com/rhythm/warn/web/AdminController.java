package com.rhythm.warn.web;


import com.rhythm.warn.annotation.DisableLogin;
import com.rhythm.warn.common.dto.LoginDTO;
import com.rhythm.warn.errorcode.ErrorCode;
import com.rhythm.warn.exception.Assert;
import com.wn.common.datamodel.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 通知管理控制器
 *
 * @author majunjie
 * @date 2018/11/19 13:08
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Value("${admin.user.account}")
    private String account;

    /**
     * 查询通知方式
     *
     * @return
     */
    @DisableLogin
    @PostMapping("/login")
    public ResponseEntity<ResultDTO<Boolean>> login(@RequestBody LoginDTO loginDTO) {
        Assert.notNull(loginDTO, ErrorCode.PARAM_DATA_NULL);
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        Assert.notEmpty(username, ErrorCode.PARAM_DATA_NULL);
        Assert.notEmpty(password, ErrorCode.PARAM_DATA_NULL);
        //原密码
        String[] split = account.split(":");
        String originUn = split[0];
        String originPw = split[1];
        //比较账号密码
        Assert.isTrue(username.equals(originUn), ErrorCode.LOGIN_FAIL);
        Assert.isTrue(password.equals(originPw), ErrorCode.LOGIN_FAIL);
        //TODO 登录信息放入session
        HttpSession session = getSession();
        String sessionId = session.getId();
        session.setAttribute(sessionId, true);
        return success(true);
    }

}

