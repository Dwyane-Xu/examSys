package com.github.dwyane.event;

import com.github.dwyane.entity.Log;
import org.springframework.context.ApplicationEvent;

/**
 * @ClassNanme: LogEvent
 * @Description: 日志事件
 * @Author: xujinzhao
 * @Date: 2020/2/18 23:46
 */
public class LogEvent extends ApplicationEvent {
    public LogEvent(Log source) {
        super(source);
    }
}
