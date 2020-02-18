package com.github.dwyane.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassNanme: GenderEnum
 * @Description: 性别枚举
 * @Author: xujinzhao
 * @Date: 2020/2/17 21:36
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

    MEN("男", 0), WOMEN("女", 1);

    private String name;

    private Integer value;

    public static GenderEnum matchByValue(Integer value) {
        for (GenderEnum item : GenderEnum.values()) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return MEN;
    }

    public static GenderEnum matchByName(String name) {
        for (GenderEnum item : GenderEnum.values()) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return MEN;
    }
}
