package com.xy.blog.service.impl;


import com.xy.blog.mapper.SysUserMapper;
import com.xy.blog.entity.SysUser;
import com.xy.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 20:16
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserMapper.getByUsername(username);
    }
}
