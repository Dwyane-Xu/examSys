package com.github.dwyane.exception;

/**
 * @ClassNanme: CommonException
 * @Description: 公共异常
 * @Author: xujinzhao
 * @Date: 2020/2/11 16:39
 */
public class CommonException extends RuntimeException {

    public CommonException() {

    }

    public CommonException(String msg) {
        super(msg);
    }

    public CommonException(Throwable throwable) {
        super(throwable);
    }
}
