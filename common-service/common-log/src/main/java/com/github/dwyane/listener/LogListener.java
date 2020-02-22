package com.github.dwyane.listener;

import com.github.dwyane.client.UserServiceClient;
import com.github.dwyane.entity.Log;
import com.github.dwyane.event.LogEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * @ClassNanme: LogListener
 * @Description: 异步监听日志事件
 * @Author: xujinzhao
 * @Date: 2020/2/18 23:52
 */
public class LogListener {

    private final UserServiceClient userServiceClient;

    @Autowired
    public LogListener(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    /**
     * 异步记录日志
     *
     * @param event event
     */
    @Async
    @Order
    @EventListener(LogEvent.class)
    public void saveSysLog(LogEvent event) {
        Log log = (Log) event.getSource();
        userServiceClient.saveLog(log);
    }
}
