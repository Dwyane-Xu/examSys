package com.github.dwyane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassNanme: ConfigApplication
 * @Description: 启动配置中心
 * @Author: xujinzhao
 * @Date: 2020/2/8 19:14
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
@SpringCloudApplication
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
