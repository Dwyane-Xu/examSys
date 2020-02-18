package com.github.dwyane.exception;

/**
 * @ClassNanme: ValidateCodeExpiredException
 * @Description: 验证码过期异常
 * @Author: xujinzhao
 * @Date: 2020/2/15 11:36
 */
public class ValidateCodeExpiredException extends CommonException {

    public ValidateCodeExpiredException() {
    }

    public ValidateCodeExpiredException(String msg) {
        super(msg);
    }
}
