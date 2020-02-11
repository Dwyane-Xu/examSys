package com.github.dwyane.exception;

/**
 * @ClassNanme: InvalidValidateCodeException
 * @Description: 验证码错误异常
 * @Author: xujinzhao
 * @Date: 2020/2/11 16:41
 */
public class InvalidValidateCodeException extends CommonException {

    public InvalidValidateCodeException() {
    }

    public InvalidValidateCodeException(String msg) {
        super(msg);
    }
}
