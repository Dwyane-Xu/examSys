package com.github.dwyane.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassNanme: ResultEnum
 * @Description: 封装常用的业务错误码和提示信息
 * @Author: xujinzhao
 * @Date: 2020/2/7 01:53
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(200, "成功"),
    PARAM_ERROR(100, "参数不正确"),
    VALIDATE_CODE_ERROR(101, "验证码错误"),
    SERVICE_ERROR(500, "服务错误"),
    ;

    private Integer code;

    private String message;

//    ResultEnum(Integer code, String message) {
//        this.code = code;
//        this.message = message;
//    }
}
