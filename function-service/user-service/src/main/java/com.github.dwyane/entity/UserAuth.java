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
import java.util.Date;

/**
 * @ClassNanme: UserAuth
 * @Description: 用户授权表实体
 * @Author: xujinzhao
 * @Date: 2020/2/20 16:29
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "sys_user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

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
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;

    public UserAuth() {
    }

    public UserAuth(Integer identityType, String identifier) {
        this.identityType = identityType;
        this.identifier = identifier;
    }
}
