package com.xy.blog.context;


import com.xy.blog.entity.SysLog;
import lombok.Data;

/**
 * 使用ThreadLocal记录线程上下文
 *
 * @Author: 夕阳
 * @Date: 2021/8/16 15:15
 * @Version 1.0
 */
@Data
public class SystemContext {

    /**
     * 日志实体
     */
    private SysLog logger;

    /**
     * 线程本地内存中的变量
     */
    private static ThreadLocal<SystemContext> threadLocal = new ThreadLocal<>();

    public static SystemContext get() {
        if (threadLocal.get() == null) {
            SystemContext context = new SystemContext();
            threadLocal.set(context);
        }
        return threadLocal.get();
    }

    public void remove() {
        threadLocal.remove();
    }

}
