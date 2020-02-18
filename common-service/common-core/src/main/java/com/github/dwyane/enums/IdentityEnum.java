package com.github.dwyane.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassNanme: IdentityEnum
 * @Description: 用户授权类型枚举
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:57
 */
@Getter
@AllArgsConstructor
public enum IdentityEnum {

    // TODO 目前只开通了密码和手机号
    PASSWORD(1, "密码"), PHONE_NUMBER(2, "手机号"), EMAIL(3, "邮箱"), WE_CHAT(4, "微信"), QQ(5, "QQ");

    private Integer value;

    private String desc;

    /**
     * 根据类型返回具体的IdentityEnum
     *
     * @param type type
     * @return IdentityEnum
     */
    public static IdentityEnum matchByType(Integer type) {
        for (IdentityEnum item : IdentityEnum.values()) {
            if (item.value.equals(type)) {
                return item;
            }
        }
        return IdentityEnum.PASSWORD;
    }

    /**
     * 根据描述返回具体的IdentityEnum
     *
     * @param desc desc
     * @return IdentityEnum
     */
    public static IdentityEnum matchByDesc(String desc) {
        for (IdentityEnum item : IdentityEnum.values()) {
            if (item.desc.equals(desc)) {
                return item;
            }
        }
        return IdentityEnum.PASSWORD;
    }
}
