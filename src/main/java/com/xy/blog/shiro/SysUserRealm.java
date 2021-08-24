package com.xy.blog.shiro;


import com.xy.blog.enums.ResultEnum;
import com.xy.blog.exception.BlogException;
import com.xy.blog.entity.SysUser;
import com.xy.blog.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 21:30
 * @Version 1.0
 */
@Component("sysUserRealm")
public class SysUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        // 获取用户名
        String username = usernamePasswordToken.getUsername();
        SysUser sysUser = sysUserService.getByUsername(username);
        if (sysUser == null) {
            throw new BlogException(ResultEnum.LOGIN_PARAM_ERROR);
        }
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), this.getName());
    }
}
