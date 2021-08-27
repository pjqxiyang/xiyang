package com.xy.blog.controller;


import com.xy.blog.entity.SysUser;
import com.xy.blog.entity.dto.PasswordDTO;
import com.xy.blog.entity.vo.TokenVo;
import com.xy.blog.enums.ResultEnum;
import com.xy.blog.service.SysUserService;
import com.xy.blog.utils.ResultUtils;
import com.xy.blog.utils.ShiroUtils;
import com.xy.blog.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 20:16
 * @Version 1.0
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录，返回token
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtils<TokenVo> login(@RequestBody SysUser sysUser) {
        if (sysUser == null || StringUtils.isBlank(sysUser.getUsername()) || StringUtils.isBlank(sysUser.getPassword())) {
            return new ResultUtils<>(ResultEnum.LOGIN_PARAM_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
        try {
            subject.login(authenticationToken);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultUtils<>(ResultEnum.LOGIN_PARAM_ERROR);
        }
        // 登录成功
        Serializable token = subject.getSession().getId();
        return new ResultUtils<>(new TokenVo(token));
    }

    /**
     * 获取当前登录用户
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResultUtils<SysUser> info() {
        SysUser sysUser = ShiroUtils.getLoginUser();
        sysUser.setPassword(null);
        return new ResultUtils<>(sysUser);
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultUtils<?> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ResultUtils<>("退出成功！");
    }

    /**
     * 修改个人信息
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/updateSysUser",method = RequestMethod.POST)
    public ResultUtils<?> updateSysUser(@RequestBody SysUser sysUser){
        sysUserService.updateSysUser(sysUser);
        return new ResultUtils<>();
    }

    /**
     * 修改密码
     * @param passwordDTO
     * @return
     */
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST)
    public ResultUtils<?> updatePwd(@RequestBody PasswordDTO passwordDTO){
        sysUserService.updatePwd(passwordDTO);
        return new ResultUtils<>();
    }

}
