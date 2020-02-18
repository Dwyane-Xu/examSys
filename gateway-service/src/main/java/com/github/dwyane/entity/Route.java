package com.github.dwyane.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @ClassNanme: Route
 * @Description: 路由信息
 * @Author: xujinzhao
 * @Date: 2020/2/15 23:30
 */
@Entity
@DynamicUpdate
@Data
@Table(name = "gateway_route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 路由ID
     */
    @NotBlank(message = "路由id不能为空")
    private String routeId;

    /**
     * 路由名称
     */
    private String routeName;

    /**
     * 断言
     */
    private String predicates;

    /**
     * 过滤器
     */
    private String filters;

    /**
     * URI
     */
    @NotBlank(message = "路由URI不能为空")
    private String uri;

    /**
     * 排序
     */
    @NotBlank(message = "排序号不能为空")
    private String sort;

    /**
     * 启用禁用
     */
    @NotBlank(message = "路由状态不能为空")
    private String status;

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 更新日期
     */
    protected Date modifyDate;
}
