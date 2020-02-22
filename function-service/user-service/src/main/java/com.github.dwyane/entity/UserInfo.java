package com.github.dwyane.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @ClassNanme: UserInfo
 * @Description: 用户信息表实体
 * @Author: xujinzhao
 * @Date: 2020/2/20 16:10
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "sys_user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Long avatarId;

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

    /**
     * 部门id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

//    /**
//     * 角色列表
//     */
//    private List<Role> roleList;

//    /**
//     * 角色
//     */
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
//    private List<Long> role;

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

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;
}
