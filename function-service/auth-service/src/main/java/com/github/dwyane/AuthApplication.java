package com.github.dwyane;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ClassNanme: AuthApplication
 * @Description: 启动auth-service
 * @Author: xujinzhao
 * @Date: 2020/2/11 17:04
 */
@SpringCloudApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
