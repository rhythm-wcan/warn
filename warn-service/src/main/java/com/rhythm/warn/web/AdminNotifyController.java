package com.rhythm.warn.web;


import com.rhythm.warn.common.dto.NotifyImplDTO;
import com.rhythm.warn.common.dto.NotifyTypeDTO;
import com.rhythm.warn.common.enums.NotifyImplCodeEnum;
import com.rhythm.warn.common.enums.NotifyTypeCodeEnum;
import com.rhythm.warn.errorcode.ErrorCode;
import com.rhythm.warn.exception.Assert;
import com.wn.common.datamodel.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    /**
     * 查询通知实现
     *
     * @return
     */
    @GetMapping("/type/impl")
    public ResponseEntity<ResultDTO<List<NotifyImplDTO>>> listNotifyImpl(NotifyImplDTO notifyImplDTO) {
        Assert.notNull(notifyImplDTO, ErrorCode.PARAM_DATA_NULL);
        String notifyCode = notifyImplDTO.getNotifyCode();

        NotifyImplCodeEnum[] values = NotifyImplCodeEnum.values();
        List<NotifyImplDTO> notifyImplDTOS = new ArrayList<>(values.length);

        if (StringUtils.isNotBlank(notifyCode)) {
            for (NotifyImplCodeEnum codeEnum : values) {
                if (notifyCode.equals(codeEnum.getTypeCode())) {
                    NotifyImplEnum2DTO(notifyImplDTOS, codeEnum);
                }
            }
            return success(notifyImplDTOS);
        }

        for (NotifyImplCodeEnum codeEnum : values) {
            NotifyImplEnum2DTO(notifyImplDTOS, codeEnum);
        }
        return success(notifyImplDTOS);
    }

    private void NotifyImplEnum2DTO(List<NotifyImplDTO> notifyImplDTOS, NotifyImplCodeEnum codeEnum) {
        NotifyImplDTO typeDTO = new NotifyImplDTO();
        typeDTO.setName(codeEnum.getName());
        typeDTO.setNotifyCode(codeEnum.getTypeCode());
        typeDTO.setNotifyImplCode(codeEnum.getCode());
        notifyImplDTOS.add(typeDTO);
    }

}

