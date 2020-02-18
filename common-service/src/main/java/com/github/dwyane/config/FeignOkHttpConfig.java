package com.github.dwyane.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @ClassNanme: FeignOkHttpConfig
 * @Description: okHttp配置
 * @Author: xujinzhao
 * @Date: 2020/2/14 16:41
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                // 连接超时
                .connectTimeout(6000, TimeUnit.SECONDS)
                // 读超时
                .readTimeout(6000, TimeUnit.SECONDS)
                // 写超时
                .writeTimeout(6000, TimeUnit.SECONDS)
                // 是否自动重连
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool())
                // 日志拦截器
                //.addInterceptor(new LogInterceptor())
                .build();
    }
}
