package com.xy.blog.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 夕阳
 * @Description:
 */
@Data
public class PasswordDTO implements Serializable {

    private static final long serialVersionUID = 2604641354372205044L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 当前密码
     */
    private String currentPwd;

    /**
     * 新密码
     */
    private String newPwd;

    /**
     * 确认新密码
     */
    private String confirmPwd;
}
