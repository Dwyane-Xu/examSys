package com.github.dwyane.filter;

import cn.hutool.core.util.StrUtil;
import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.constant.GatewayConstant;
import com.github.dwyane.properties.SysProperties;
import com.github.dwyane.utils.SysUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @ClassNanme: DecodePasswordFilter
 * @Description: 解密过滤器
 * @Author: xujinzhao
 * @Date: 2020/2/14 23:55
 */
@Slf4j
@Component
public class DecodePasswordFilter implements GlobalFilter, Ordered {

    private final SysProperties sysProperties;

    private static final String CREDENTIAL = "credential";

    private static final String PASSWORD = "password";

    @Autowired
    public DecodePasswordFilter(SysProperties sysProperties) {
        this.sysProperties = sysProperties;
    }

    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 当前请求
        ServerHttpRequest request = exchange.getRequest();
        // 请求的URI
        URI uri = request.getURI();
        // 获取token的请求
        if (HttpMethod.POST.matches(request.getMethodValue())
                && StrUtil.containsAnyIgnoreCase(uri.getPath(), GatewayConstant.OAUTH_TOKEN_URL,
                GatewayConstant.REGISTER, GatewayConstant.MOBILE_TOKEN_URL)) {
            String grantType = request.getQueryParams().getFirst(GatewayConstant.GRANT_TYPE);
            // 授权类型为密码模式则解密
            if (CommonConstant.GRANT_TYPE_PASSWORD.equals(grantType) || StrUtil.containsAnyIgnoreCase(uri.getPath(), GatewayConstant.REGISTER)) {
                String credential = request.getQueryParams().getFirst(CREDENTIAL);
                if (StringUtils.isNotBlank(credential)) {
                    try {
                        // 开始解密
                        credential = SysUtil.decryptAES(credential, sysProperties.getKey());
                        credential = credential.trim();
                    } catch (Exception e) {
                        log.error("credential decrypt fail:{}", credential);
                    }
                    URI newUri = UriComponentsBuilder.fromUri(uri)
                            // 替换password字段
                            .replaceQueryParam(PASSWORD, credential)
                            // 替换credential字段
                            .replaceQueryParam(CREDENTIAL, credential)
                            .build(true).toUri();
                    request = request.mutate().uri(newUri).build();
                    return chain.filter(exchange.mutate().request(request).build());
                }
            }
        }
        return chain.filter(exchange);
    }

}
