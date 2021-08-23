package com.xy.blog.utils;


import com.xy.blog.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 * @Author: 夕阳
 * @Date: 2021/8/16 14:50
 * @Version 1.0
 */
@Data
public class ResultUtils<T> implements Serializable {

    private static final long serialVersionUID = -5222629900503813556L;

    private Integer code;

    private String msg;

    private T data;

    public ResultUtils() {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
    }

    public ResultUtils(String msg) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
    }

    public ResultUtils(T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public ResultUtils(String msg, T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultUtils(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ResultUtils(ResultEnum resultEnum, String msg) {
        this.code = resultEnum.getCode();
        this.msg = msg;
    }

    public static ResultUtils<?> error() {
        return new ResultUtils<>(ResultEnum.ERROR);
    }

    public static ResultUtils<?> ok() {
        return new ResultUtils<>();
    }

}
