package com.github.dwyane.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassNanme: RestTemplateConfig
 * @Description: RestTemplateConfig
 * @Author: xujinzhao
 * @Date: 2020/2/14 16:50
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
