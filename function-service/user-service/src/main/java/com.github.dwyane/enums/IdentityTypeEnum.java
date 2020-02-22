package com.github.dwyane.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassNanme: IdentityTypeEnum
 * @Description: 用户授权类型枚举
 * @Author: xujinzhao
 * @Date: 2020/2/22 17:56
 */
@Getter
@AllArgsConstructor
public enum  IdentityTypeEnum {

    // 现在只有密码和手机号方式
    PASSWORD(1, "密码"), PHONE_NUMBER(2, "手机号"), EMAIL(3, "邮箱"), WE_CHAT(4, "微信"), QQ(5, "QQ");

    private Integer value;

    private String desc;

    /**
     * 根据类型返回具体的IdentityType
     *
     * @param type type
     * @return IdentityType
     */
    public static IdentityTypeEnum matchByType(Integer type) {
        for (IdentityTypeEnum item : IdentityTypeEnum.values()) {
            if (item.value.equals(type)) {
                return item;
            }
        }
        return IdentityTypeEnum.PASSWORD;
    }

    /**
     * 根据描述返回具体的IdentityType
     *
     * @param desc desc
     * @return IdentityType
     */
    public static IdentityTypeEnum matchByDesc(String desc) {
        for (IdentityTypeEnum item : IdentityTypeEnum.values()) {
            if (item.desc.equals(desc)) {
                return item;
            }
        }
        return IdentityTypeEnum.PASSWORD;
    }
}
