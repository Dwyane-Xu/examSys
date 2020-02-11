package com.github.dwyane;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @ClassNanme: GatewayApplication
 * @Description: 启动gateway-service
 * @Author: xujinzhao
 * @Date: 2020/2/11 02:11
 */
@EnableJpaAuditing
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GatewayApplication.class, args);
    }
}
