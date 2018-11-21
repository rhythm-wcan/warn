package com.rhythm.warn.web;

import com.wn.common.datamodel.ResultDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author majunjie
 * @date 2018/11/21 16:22
 */
public class BaseController {
    public HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    public Map<String, Object> response(Boolean success, int code, String msg, Object data) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("success", success);
        responseMap.put("code", code);
        responseMap.put("message", msg);
        responseMap.put("data", data);
        return responseMap;
    }

    public ResponseEntity<Object> ok(String voKey, Object vo) {
        Map<String, Object> voMap = new HashMap<>();
        voMap.put(voKey, vo);
        return ok(voMap);
    }

    public ResponseEntity<Object> ok(Object data) {
        return ResponseEntity.ok(response(true, 0, "success", data));
    }

    public ResponseEntity<Object> ok() {
        return ok(null);
    }

    protected <T> ResponseEntity<ResultDTO<T>> success(T data) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setSuccess(true);
        resultDTO.setCode("0");
        resultDTO.setMessage("");
        resultDTO.setData(data);
        return ResponseEntity.ok(resultDTO);
    }

    protected <T> ResponseEntity<ResultDTO<T>> error(String errorCode, String errorMsg) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setSuccess(false);
        resultDTO.setCode(errorCode);
        resultDTO.setMessage(errorMsg);
        return ResponseEntity.ok(resultDTO);
    }

    protected <T> ResponseEntity<ResultDTO<T>> failure(String code, String message) {
        return error(code, message);
    }

    protected <T> ResponseEntity<ResultDTO<T>> success() {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setSuccess(true);
        resultDTO.setCode("0");
        resultDTO.setMessage("");
        return ResponseEntity.ok(resultDTO);
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    public String getIpAddr() {
        HttpServletRequest request = getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

} 
