package com.rhythm.warn.web;


import com.wn.common.datamodel.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知
 *
 * @author majunjie
 * @date 2018/11/19 13:08
 */
@RestController
@RequestMapping("/notify")
@Slf4j
public class NotifyController extends BaseController {

    /**
     * 心跳接口
     *
     * @return
     */
    @GetMapping("/heartbeat")
    public ResponseEntity<ResultDTO<String>> heartbeat() {
        return success("hello world");
    }

}

