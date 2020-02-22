package com.github.dwyane.client.factory;

import com.github.dwyane.client.UserServiceClient;
import com.github.dwyane.client.fallback.UserServiceClientFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassNanme: UserServiceClientFallbackFactory
 * @Description: 用户断路器工厂
 * @Author: xujinzhao
 * @Date: 2020/2/18 23:57
 */
@Component
public class UserServiceClientFallbackFactory implements FallbackFactory<UserServiceClient> {

    @Override
    public UserServiceClient create(Throwable throwable) {
        UserServiceClientFallback userServiceClientFallback = new UserServiceClientFallback();
        userServiceClientFallback.setThrowable(throwable);
        return userServiceClientFallback;
    }
}
