package com.xy.blog.service.impl;


import com.xy.blog.entity.dto.PasswordDTO;
import com.xy.blog.exception.BlogException;
import com.xy.blog.mapper.SysUserMapper;
import com.xy.blog.entity.SysUser;
import com.xy.blog.service.SysUserService;
import com.xy.blog.utils.ShiroUtils;
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

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Override
    public SysUser getByUsername(String username) {
        return sysUserMapper.getByUsername(username);
    }

    /**
     * 修改个人信息
     * @param sysUser
     */
    @Override
    public void updateSysUser(SysUser sysUser) {
        int result = sysUserMapper.updateSysUser(sysUser);
        if (result == 0){
            throw new BlogException("修改失败");
        }
        ShiroUtils.setUser(sysUser);
    }

    /**
     * 修改密码
     * @param passwordDTO
     */
    @Override
    public void updatePwd(PasswordDTO passwordDTO) {
        // 根据当前id获取个人信息
        SysUser sysUser = ShiroUtils.getLoginUser();
        passwordDTO.setId(sysUser.getId());
        // 判断当前密码是否正确
        if (!sysUser.getId().equals(passwordDTO.getId())){
            throw new BlogException("当前密码错误");
        }
        // 修改密码
        int result = sysUserMapper.updatePwd(passwordDTO);
        if (result == 0){
            throw new BlogException("修改密码失败");
        }
    }
}
