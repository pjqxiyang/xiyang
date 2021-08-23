package com.xy.blog.exception;


import com.xy.blog.enums.ResultEnum;
import lombok.Data;

/**
 * 全局异常类
 * @Author: 夕阳
 * @Date: 2021/8/16 14:55
 * @Version 1.0
 */
@Data
public class BlogException extends RuntimeException {

    /**
     * 错误状态码
     */
    private Integer errorCode = ResultEnum.ERROR.getCode();

    public BlogException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }

    public BlogException(Integer errorCode) {
        super();
        this.errorCode = errorCode;
    }


    public BlogException(String message) {
        super(message);
    }

    public BlogException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BlogException(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BlogException(Throwable cause, Integer errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BlogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }


}
