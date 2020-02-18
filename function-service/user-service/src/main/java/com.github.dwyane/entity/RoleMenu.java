package com.github.dwyane.entity;

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
 * @ClassNanme: RoleMenu
 * @Description: 角色菜单关联实体
 * @Author: xujinzhao
 * @Date: 2020/2/16 17:20
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "user_role_menu")
public class RoleMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 更新日期
     */
    protected Date modifyDate;
}
