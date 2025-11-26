package com.somemore.springboot_demo.exception;

import com.somemore.springboot_demo.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // 专门统一处理
public class GlobalExceptionHandlerAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseMessage handlerException(Exception e, HttpServletRequest request, HttpServletResponse response){
        log.error("统一错误处理：" + e.getMessage());
        return new ResponseMessage<>(500, "error", null);
    }
}
