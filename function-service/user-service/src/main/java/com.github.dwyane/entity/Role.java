package com.github.dwyane.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @ClassNanme: Role
 * @Description: 角色实体
 * @Author: xujinzhao
 * @Date: 2020/2/7 22:26
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色标识
     */
    @NotBlank(message = "角色标识不能为空")
    private String roleCode;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 角色状态
     */
    private Integer status;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新日期
     */
    private Date modifyDate;

    /**
     * 是否默认，0-否 1-是
     */
    private Integer isDefault;
}
