package com.github.dwyane;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @ClassNanme: UserApplication
 * @Description: 启动user-service
 * @Author: xujinzhao
 * @Date: 2020/2/6 00:47
 */
@EnableJpaAuditing
@SpringCloudApplication
public class UserApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class, args);
    }
}
