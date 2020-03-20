package com.hom.springdemo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private final HttpServletResponse response;

    public GlobalExceptionHandler(HttpServletResponse response) {
        this.response = response;
    }

    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> baseException(Exception exception) {
        log.info("系统异常:{}", exception.getMessage());
        exception.printStackTrace();
        Map<String, Object> resultHashMap = new HashMap<>();
        resultHashMap.put("desc", "系统繁忙，请稍后再试");
        resultHashMap.put("result", -1);
        return resultHashMap;
    }


    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public void handlerSellerException(BusinessException e) throws IOException {
        log.info("抛出异常：{}", e.getMessage());
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
    }

}
