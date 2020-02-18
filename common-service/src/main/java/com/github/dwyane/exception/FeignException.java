package com.github.dwyane.exception;

/**
 * @ClassNanme: FeignException
 * @Description: Feign exception
 * @Author: xujinzhao
 * @Date: 2020/2/12 23:27
 */
public class FeignException extends CommonException {

    public FeignException() {}

    public FeignException(String msg) {
        super(msg);
    }
}
