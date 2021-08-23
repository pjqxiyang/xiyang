package com.xy.blog.service;


import com.xy.blog.entity.SysLog;

/**
 * @Author: 夕阳
 * @Date: 2021/8/16 15:20
 * @Version 1.0
 */
public interface SysLogService {

    /**
     * 保存日志
     * @param sysLog
     */
    void save(SysLog sysLog);

}
