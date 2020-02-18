package com.github.dwyane.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassNanme: LoginTypeEnum
 * @Description: 登录类型枚举
 * @Author: xujinzhao
 * @Date: 2020/2/10 17:42
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    /**
     * 账号密码登录
     */
    PWD("PWD", "账号密码登录", "/oauth/token"),

    /**
     * 验证码登录
     */
    SMS("SMS", "验证码登录", "/mobile/token"),
    ;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 接口uri
     */
    private String uri;
}
