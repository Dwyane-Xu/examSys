package com.github.dwyane.interceptor;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @ClassNanme: LogInterceptor
 * @Description: 日志拦截器
 * @Author: xujinzhao
 * @Date: 2020/2/18 22:57
 */
@Slf4j
public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        long t1 = System.nanoTime();
        Request request = chain.request();
        log.debug(String.format("sending %s request %s%n%s", request.method(),
                request.url(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        log.debug(String.format("received response for %s in %.1fms%n%s", response.request().url(),
                (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}
