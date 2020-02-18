package com.github.dwyane.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassNanme: StatusEnum
 * @Description: 状态枚举
 * @Author: xujinzhao
 * @Date: 2020/2/17 21:40
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    ENABLE("启用", 0), DISABLE("禁用", 1);

    private String name;

    private Integer value;

    public static StatusEnum matchByValue(Integer value) {
        for (StatusEnum item : StatusEnum.values()) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return ENABLE;
    }

    public static StatusEnum matchByName(String name) {
        for (StatusEnum item : StatusEnum.values()) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return ENABLE;
    }
}
