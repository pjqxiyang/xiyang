package com.xy.blog.shiro;

import com.alibaba.fastjson.JSON;
import com.xy.blog.enums.ResultEnum;
import com.xy.blog.utils.ResultUtils;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: 夕阳
 * @Date: 2021/8/24 21:23
 * @Version 1.0
 */
public class LoginFilter extends UserFilter {

    /**
     * 该方法用于处理登录时页面重定向的逻辑
     * 如果没有登陆，就调用该方法
     * 我们只需要在这个方法里，给前端返回一个登录失败的状态即可。
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        // 设置响应头
        response.setContentType("application/json; charset=utf-8");
        // 直接写回未登录的json报文
        response.getWriter().write(JSON.toJSONString(new ResultUtils<>(ResultEnum.NOT_LOGIN)));
    }
}
