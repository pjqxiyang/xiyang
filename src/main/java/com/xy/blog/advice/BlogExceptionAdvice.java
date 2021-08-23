package com.xy.blog.advice;


import com.xy.blog.exception.BlogException;
import com.xy.blog.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 夕阳
 * @Date: 2021/8/16 14:54
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class BlogExceptionAdvice {

    /**
     * 全局异常处理器
     * @param blogException
     * @return
     */
    @ExceptionHandler(BlogException.class)
    public ResultUtils<?> exceptionHandler(BlogException blogException) {
        log.error("统一异常处理：", blogException);
        return new ResultUtils<>(blogException.getErrorCode(), blogException.getMessage());
    }

}
