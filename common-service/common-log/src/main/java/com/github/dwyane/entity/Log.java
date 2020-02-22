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
 * @ClassNanme: Log
 * @Description: 日志实体
 * @Author: xujinzhao
 * @Date: 2020/2/18 11:29
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Data
@Table(name = "sys_log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 日志标题
     */
    @NotBlank(message = "日志标题不能为空")
    private String title;

    /**
     * 操作用户的IP地址
     */
    private String ip;

    /**
     * 操作用户代理信息
     */
    private String userAgent;

    /**
     * 操作的URI
     */
    private String requestUri;

    /**
     * 操作的方式
     */
    private String method;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 异常信息
     */
    private String exception;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 耗时
     */
    private String time;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String modifier;
}
