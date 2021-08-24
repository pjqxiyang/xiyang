package com.xy.blog.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * VO：View Object 视图对象
 *
 * @Author: 夕阳
 * @Date: 2021/8/24 20:17
 * @Version 1.0
 */
@Data
public class TokenVo implements Serializable {

    private Serializable token;

    public TokenVo(Serializable token) {
        this.token = token;
    }
}
