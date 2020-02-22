package com.github.dwyane.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.dwyane.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNanme: UserDto
 * @Description: User Dto
 * @Author: xujinzhao
 * @Date: 2020/2/21 18:39
 */
@Data
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto {

    /**
     * id
     */
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
     * 密码凭证，跟授权类型有关，如密码、第三方系统的token等
     */
    private String credential;

    /**
     * 角色
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private List<Long> role = new ArrayList<>();

    /**
     * 部门ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    @Pattern(regexp = "^\\d{11}$", message = "请输入11位手机号")
    private String phone;

    /**
     * 头像id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long avatarId;

    /**
     * 头像URL
     */
    private String avatarUrl;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private Date born;

    /**
     * 描述
     */
    private String userDesc;

    /**
     * 状态
     */
    private Integer status;

//    /**
//     * 角色列表
//     */
//    private List<Role> roleList = new ArrayList<>();

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
