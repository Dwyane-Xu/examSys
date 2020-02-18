package com.github.dwyane;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassNanme: MsgApplication
 * @Description: 启动msg-service
 * @Author: xujinzhao
 * @Date: 2020/2/12 02:56
 */
@EnableFeignClients
@SpringCloudApplication
public class MsgApplication {

    public static void main(String[] args) {

        SpringApplication.run(MsgApplication.class, args);
    }
}
