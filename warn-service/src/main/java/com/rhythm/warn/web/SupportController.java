package com.rhythm.warn.web;


import com.wn.common.auth.permission.DisableLoginVerify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo
 *
 * @author majunjie
 * @date 2018/11/19 13:08
 */
@RestController
@RequestMapping("/support")
@Slf4j
public class SupportController {

    /**
     * 心跳接口
     *
     * @return
     */
    @GetMapping("/heartbeat")
    @DisableLoginVerify
    public String heartbeat() {
        return "hello world";
    }

}

