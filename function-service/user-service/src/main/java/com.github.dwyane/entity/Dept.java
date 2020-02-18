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
 * @ClassNanme: Dept
 * @Description: 部门实体
 * @Author: xujinzhao
 * @Date: 2020/2/6 01:26
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "user_dept")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    private String deptName;

    /**
     * 部门描述
     */
    private String deptDesc;

    /**
     * 部门负责人
     */
    private String deptLeader;

    /**
     * 父部门
     */
    private Long parentId;

    /**
     * 排序号
     */
    @NotBlank(message = "排序号不能为空")
    private Integer sort;

    /**
     * 创建日期
     */
    protected Date createDate;

    /**
     * 更新日期
     */
    protected Date modifyDate;
}
