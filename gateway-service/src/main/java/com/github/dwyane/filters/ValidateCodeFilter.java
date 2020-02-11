package com.github.dwyane.filters;

import cn.hutool.core.util.StrUtil;
import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.constant.GatewayConstant;
import com.github.dwyane.enums.LoginTypeEnum;
import com.github.dwyane.exception.InvalidValidateCodeException;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @ClassNanme: ValidateCodeFilter
 * @Description: 验证码过滤器
 * @Author: xujinzhao
 * @Date: 2020/2/11 15:37
 */
@Component
public class ValidateCodeFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        // uri判断
        if (HttpMethod.POST.matches(request.getMethodValue())
                && StrUtil.containsAnyIgnoreCase(uri.getPath(), GatewayConstant.OAUTH_TOKEN_URL,
                GatewayConstant.REGISTER, GatewayConstant.MOBILE_TOKEN_URL)) {
            // 授权类型为密码模式、手机号、注册才校验验证码
            String grantType = request.getQueryParams().getFirst(GatewayConstant.GRANT_TYPE);
            if (CommonConstant.GRANT_TYPE_PASSWORD.equals(grantType) ||
                    CommonConstant.GRANT_TYPE_MOBILE.equals(grantType) ||
                    StrUtil.containsAnyIgnoreCase(uri.getPath(), GatewayConstant.REGISTER)) {
                checkCode(request, getLoginType(grantType));
            }
        }

        return chain.filter(exchange);
    }

    /**
     * 校验验证码
     */
    private void checkCode(ServerHttpRequest serverHttpRequest, LoginTypeEnum loginType) {
        MultiValueMap<String, String> params = serverHttpRequest.getQueryParams();
        String code = params.getFirst("code");
        if (StrUtil.isBlank(code)) {
            throw new InvalidValidateCodeException("请输入验证码");
        }
        // 获取随机码
        String randomStr = params.getFirst("randomStr");
        // 随机数为空，则获取手机号
        if (StrUtil.isBlank(randomStr)) {
            randomStr = params.getFirst("mobile");
        }
    }

    /**
     * 获取登陆类型
     */
    private LoginTypeEnum getLoginType(String grantType) {
        if (CommonConstant.GRANT_TYPE_MOBILE.equals(grantType)) {
            return LoginTypeEnum.SMS;
        } else  {
            return LoginTypeEnum.PWD;
        }
    }
}
