package com.xy.blog.mapper;

import com.xy.blog.entity.SysUser;
import com.xy.blog.entity.dto.PasswordDTO;
import org.springframework.stereotype.Component;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 20:15
 * @Version 1.0
 */
@Component
public interface SysUserMapper {
    /**
     * 根据用户名查询
     * @param username 用户名
     * @return
     */
    SysUser getByUsername(String username);

    /**
     * 修改密码
     * @param passwordDTO
     * @return
     */
    int updatePwd(PasswordDTO passwordDTO);

    /**
     * 修改个人信息
     * @param sysUser
     * @return
     */
    int updateSysUser(SysUser sysUser);
}
