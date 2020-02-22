package com.github.dwyane.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNanme: FilterIgnoreProperties
 * @Description: 不做权限拦截的url
 * @Author: xujinzhao
 * @Date: 2020/2/20 01:07
 */
@Data
@Configuration
@RefreshScope
@ConditionalOnExpression("!'${ignore}'.isEmpty()")
@ConfigurationProperties(prefix = "ignore")
public class FilterIgnoreProperties {

    private List<String> urls = new ArrayList<>();
}
