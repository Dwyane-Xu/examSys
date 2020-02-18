package com.github.dwyane.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNanme: SysProperties
 * @Description: 系统相关配置
 * @Author: xujinzhao
 * @Date: 2020/2/15 00:02
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "sys")
public class SysProperties {

    /**
     * 管理员账号
     */
    private String adminUser;

    /**
     * 密码加密解密的key
     */
    private String key;

    /**
     * 缓存超时时间
     */
    private String cacheExpire;
}
