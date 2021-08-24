package com.xy.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 20:13
 * @Version 1.0
 */
@Data
public class SysUser implements Serializable {

    /**
     * ID，自增
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String header;

    /**
     * 签名
     */
    private String signature;

    /**
     * 介绍
     */
    private String comment;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
