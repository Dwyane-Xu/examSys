package com.github.dwyane.client.factory;

import com.github.dwyane.client.MsgServiceClient;
import com.github.dwyane.client.fallback.MsgServiceClientFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassNanme: MsgServiceClientFallbackFactory
 * @Description: msg-ervice client fallback factory
 * @Author: xujinzhao
 * @Date: 2020/2/12 22:56
 */
@Component
public class MsgServiceClientFallbackFactory implements FallbackFactory<MsgServiceClient> {

    @Override
    public MsgServiceClient create(Throwable throwable) {
        MsgServiceClientFallback msgServiceClientFallback = new MsgServiceClientFallback();
        msgServiceClientFallback.setThrowable(throwable);
        return msgServiceClientFallback;
    }
}
