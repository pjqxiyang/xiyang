package com.xy.blog.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * @Author: 夕阳
 * @Date: 2021/8/16 15:13
 * @Version 1.0
 */
@Data
public class SysLog implements Serializable {

    /**
     * ID
     */
    private Long logId;

    /**
     * 请求地址
     */
    private String logUrl;

    /**
     * 请求参数，json格式
     */
    private String logParams;

    /**
     * 访问状态，1 正常 ，0 异常
     */
    private Integer logStatus;

    /**
     * 异常文本
     */
    private String logMessage;

    /**
     * 浏览器UA表示
     */
    private String logUa;

    /**
     * controller
     */
    private String logController;

    /**
     * 请求方式，GET、POST
     */
    private String logMethod;

    /**
     * 响应时间
     */
    private Long logTime;

    /**
     * 返回结果
     */
    private String logResult;

    /**
     * 登录ip
     */
    private String logIp;

    /**
     * 创建时间
     */
    private String createdDate;

    /**
     * 创建人
     */
    private String createdBy;

}
