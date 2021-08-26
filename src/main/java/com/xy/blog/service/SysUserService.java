package com.xy.blog.service;

import com.xy.blog.entity.SysUser;
import com.xy.blog.entity.dto.PasswordDTO;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 20:16
 * @Version 1.0
 */
public interface SysUserService {


    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    SysUser getByUsername(String username);

    /**
     * 修改个人信息
     * @param sysUser
     */
    void updateSysUsesr(SysUser sysUser);

    /**
     * 修改密码
     * @param passwordDTO
     */
    void updatePwd(PasswordDTO passwordDTO);
}
