package com.github.dwyane.mobile;

import lombok.Data;

/**
 * @ClassNanme: MobileUser
 * @Description: 手机用户信息
 * @Author: xujinzhao
 * @Date: 2020/2/20 01:58
 */
@Data
public class MobileUser {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 详细描述
     */
    private String userDesc;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;
}
