package com.github.dwyane.config;

import com.github.dwyane.aspect.LogAspect;
import com.github.dwyane.client.UserServiceClient;
import com.github.dwyane.listener.LogListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @ClassNanme: LogConfig
 * @Description: 日志配置
 * @Author: xujinzhao
 * @Date: 2020/2/19 00:18
 */
@EnableAsync
@Configuration
@ConditionalOnWebApplication
public class LogConfig {

    private final UserServiceClient userServiceClient;

    @Autowired
    public LogConfig(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Bean
    public LogListener sysLogListener() {
        return new LogListener(userServiceClient);
    }

    @Bean
    public LogAspect sysLogAspect() {
        return new LogAspect();
    }
}
