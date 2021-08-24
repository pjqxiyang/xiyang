package com.xy.blog.service;

import com.xy.blog.entity.SysUser;

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
}
