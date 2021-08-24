package com.xy.blog.shiro;

import com.xy.blog.utils.StringUtils;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.UUID;

/**
 * @Author: 杨德石
 * @Date: 2021/1/2 21:20
 * @Version 1.0
 */
@Configuration
public class TokenWebSessionManager extends DefaultWebSessionManager {

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // 从请求头获取token
        String token = WebUtils.toHttp(request).getHeader("Authorization");
        // 如果token存在，就返回token，否则就生成一个
        if (StringUtils.isNotBlank(token)) {
            return token;
        }
        return UUID.randomUUID().toString();
    }
}
