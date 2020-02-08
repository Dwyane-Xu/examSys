package com.github.dwyane;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @ClassNanme: ExamApplication
 * @Description: 启动exam-service
 * @Author: xujinzhao
 * @Date: 2020/2/5 11:34
 */
@EnableJpaAuditing
@SpringCloudApplication
public class ExamApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExamApplication.class, args);
    }
}
