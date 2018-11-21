package com.rhythm.warn.web;


import com.rhythm.warn.common.dto.NotifyTypeDTO;
import com.rhythm.warn.common.enums.NotifyTypeCodeEnum;
import com.wn.common.datamodel.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知管理控制器
 *
 * @author majunjie
 * @date 2018/11/19 13:08
 */
@RestController
@RequestMapping("/admin/notify")
@Slf4j
public class AdminNotifyController extends BaseController {

    /**
     * 查询通知方式
     *
     * @return
     */
    @GetMapping("/type")
    public ResponseEntity<ResultDTO<List<NotifyTypeDTO>>> listNotifyType() {
        NotifyTypeCodeEnum[] values = NotifyTypeCodeEnum.values();
        List<NotifyTypeDTO> typeDTOS = new ArrayList<>(values.length);
        for (NotifyTypeCodeEnum codeEnum : values) {
            NotifyTypeDTO typeDTO = new NotifyTypeDTO();
            typeDTO.setName(codeEnum.getName());
            typeDTO.setNotifyCode(codeEnum.getCode());
            typeDTOS.add(typeDTO);
        }
        return success(typeDTOS);
    }

}

