package com.github.dwyane.enums;

import lombok.Getter;

/**
 * @ClassNanme: ResultEnum
 * @Description: 封装常用的业务错误码和提示信息
 * @Author: xujinzhao
 * @Date: 2020/2/7 01:53
 */
@Getter
public enum  ResultEnum {

    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
