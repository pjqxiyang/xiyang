package com.xy.blog.mapper;


import com.xy.blog.entity.SysLog;
import org.springframework.stereotype.Component;

/**
 * @Author: 夕阳
 * @Date: 2021/8/16 15:18
 * @Version 1.0
 */
@Component
public interface SysLogMapper {

    /**
     * 保存日志
     * @param sysLog
     */
    void save(SysLog sysLog);

}
