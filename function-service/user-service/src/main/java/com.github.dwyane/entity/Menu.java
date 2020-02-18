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
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @ClassNanme: Menu
 * @Description: 菜单实体
 * @Author: xujinzhao
 * @Date: 2020/2/16 15:53
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "user_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单名称
     */
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    /**
     * 菜单权限标识
     */
    @NotBlank(message = "菜单标识不能为空")
    private String permission;

    /**
     * url
     */
    private String url;

    /**
     * 重定向url
     */
    private String redirect;

    /**
     * 父菜单ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序号
     */
    @NotBlank(message = "排序号不能为空")
    private String sort;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 模块
     */
    private String component;

    /**
     * 路径
     */
    private String path;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 更新日期
     */
    protected Date modifyDate;
}
