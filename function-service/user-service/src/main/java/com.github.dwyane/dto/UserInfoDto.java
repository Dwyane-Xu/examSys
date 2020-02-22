package com.github.dwyane.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNanme: UserInfoDto
 * @Description: UserInfo Dto
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:30
 */
@Data
public class UserInfoDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 授权类型，1：用户名密码，2：手机号，3：邮箱，4：微信，5：QQ
     */
    private Integer identityType;

    /**
     * 唯一标识，如用户名、手机号
     */
    private String identifier;

    /**
     * 密码
     */
    @JsonIgnore
    private String credential;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 头像对应的附件id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long avatarId;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日
     */
    private Date born;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态，0-启用，1-禁用
     */
    private Integer status;

    /**
     * 权限信息
     */
    private String[] permissions;

    /**
     * 角色信息
     */
    private String[] roles;

    /**
     * 省份
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long provinceId;

    /**
     * 城市
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long cityId;

    /**
     * 县
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long countyId;

    /**
     * 最近登录时间
     */
    private Date loginTime;

    /**
     * 用户归档时间
     */
    private Date lockTime;

    /**
     * 微信
     */
    private String wechat;
}
