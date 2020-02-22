package com.github.dwyane.aspect;

import com.github.dwyane.annotation.LogValue;
import com.github.dwyane.entity.Log;
import com.github.dwyane.event.LogEvent;
import com.github.dwyane.util.LogUtil;
import com.github.dwyane.utils.SpringContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassNanme: LogAspect
 * @Description: 日志切面，异步记录日志
 * @Author: xujinzhao
 * @Date: 2020/2/19 01:22
 */
@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(logValue)")
    public Object around(ProceedingJoinPoint point, LogValue logValue) throws Throwable {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        logger.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);
        Log logVo = LogUtil.getLog();
        logVo.setTitle(logValue.value());
        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj = point.proceed();
        Long endTime = System.currentTimeMillis();
        logVo.setTime(String.valueOf(endTime - startTime));
        SpringContextHolder.publishEvent(new LogEvent(logVo));
        return obj;
    }
}
