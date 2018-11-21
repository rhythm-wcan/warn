package com.rhythm.warn.config;

import com.rhythm.warn.common.dto.NotifyTypeDTO;
import com.rhythm.warn.exception.BusinessException;
import com.rhythm.warn.web.BaseController;
import com.wn.common.datamodel.ResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author majunjie
 * @date 2018/11/21 17:08
 */
@ControllerAdvice
public class MyControllerAdvice extends BaseController {

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResultDTO<NotifyTypeDTO>> errorHandler(Exception ex) {
        return failure("9999", ex.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 BusinessException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ResultDTO<NotifyTypeDTO>> myErrorHandler(BusinessException ex) {
        return failure(ex.getCode(), ex.getMessage());
    }

}
