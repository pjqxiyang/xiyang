package com.xy.blog.service.impl;


import com.xy.blog.entity.SysLog;
import com.xy.blog.mapper.SysLogMapper;
import com.xy.blog.service.SysLogService;
import com.xy.blog.utils.IdWorkerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 夕阳
 * @Date: 2021/8/16 15:20
 * @Version 1.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;
    @Autowired
    private IdWorkerUtils idWorker;

    @Override
    public void save(SysLog sysLog) {
        sysLog.setLogId(idWorker.nextId());
        sysLog.setCreatedBy("admin");
        sysLogMapper.save(sysLog);
    }

}
