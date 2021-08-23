package com.xy.blog.aop;

import com.alibaba.fastjson.JSON;
import com.xy.blog.context.SystemContext;
import com.xy.blog.entity.SysLog;
import com.xy.blog.enums.StateEnums;
import com.xy.blog.service.SysLogService;
import com.xy.blog.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * 日志记录AOP
 * @Author: 夕阳
 * @Date: 2021/8/16 15:22
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class RequestAspect {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 声明切点
     */
    @Pointcut("execution( * com.xy.blog.controller..*(..))")
    public void logPointCut() {
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        // 获取request
        HttpServletRequest request = attributes.getRequest();
        // 工艺区去颁发区域yrk
        String uri = request.getRequestURI();
        // 获取请求方式
        String method = request.getMethod();
        // 获取请求IP
        String ip = StringUtils.getRemoteIp(request);
        log.info("请求地址：{}", uri);
        log.info("请求方式：{}", method);
        log.info("请求IP：{}", ip);
        // 获取请求的controller
        String controller = pjp.getSignature().getDeclaringTypeName();
        log.info("请求方法：{}.{}", controller, pjp.getSignature().getName());
        // 获取参数
        Object[] args = pjp.getArgs();
        // 参数不为空，且第一个参数不是Request也不是MultipartFile
        boolean logParamFlag = args != null && args.length > 0 && !(args[0] instanceof ServletRequest) && !(args[0] instanceof MultipartFile);
        // 获取线程上下文
        SysLog sysLog = SystemContext.get().getLogger();
        if(sysLog == null) {
            sysLog = new SysLog();
            SystemContext.get().setLogger(sysLog);
        }
        if (logParamFlag) {
            String params = JSON.toJSONString(args[0]);
            log.info("请求参数：{}", params);
            sysLog.setLogParams(params);
        }
        // 记录日志
        sysLog.setLogUrl(uri);
        sysLog.setLogStatus(StateEnums.REQUEST_SUCCESS.getCode());
        sysLog.setLogMethod(method);
        sysLog.setLogIp(ip);
        sysLog.setLogUa(request.getHeader("user-Agent"));
        sysLog.setLogController(controller);
        // 记录方法执行时间
        long start = System.currentTimeMillis();
        Object ob = pjp.proceed();
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("方法执行耗时：{}", time);
        sysLog.setLogTime(time);
        // 记录返回值
        String result = JSON.toJSONString(ob);
        log.info("返回值：{}", result);
        sysLog.setLogResult(result);
        // 记录日志
        sysLogService.save(sysLog);
        SystemContext.get().remove();
        return ob;
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param throwable
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "throwable")
    public void doException(JoinPoint joinPoint, Throwable throwable) {
        SysLog sysLog = SystemContext.get().getLogger();
        sysLog.setLogStatus(StateEnums.REQUEST_ERROR.getCode());
        sysLog.setLogMessage(throwable.getMessage());
        sysLog.setLogTime(-1L);
        sysLogService.save(sysLog);
        SystemContext.get().remove();
    }

}
