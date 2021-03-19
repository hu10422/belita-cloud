package com.balita.service.order.handler;


import cn.hutool.core.util.StrUtil;
import com.beilita.common.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public JsonResult defaultErrorHandler(HttpServletRequest req, Exception e) {
        log.error("ExceptionHandler ===>" + e.getMessage());
        // 这里可根据不同异常引起的类做不同处理方式
        String exceptionName = ClassUtils.getShortName(e.getClass());
        log.error("ExceptionHandler ===>" + exceptionName);

        e.printStackTrace();

        return JsonResult.error(StrUtil.format("统一异常处理【{}】", exceptionName));
    }
}