package com.github.dwyane.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @ClassNanme: Course
 * @Description: 课程实体
 * @Author: xujinzhao
 * @Date: 2020/2/5 17:14
 */
@Entity
@DynamicUpdate
@Data
@Table(name = "exam_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 课程名称
     */
    @NotBlank(message = "课程名称不能为空")
    private String courseName;

    /**
     * 学院
     */
    private String college;

    /**
     * 专业
     */
    private String major;

    /**
     * 老师
     */
    private String teacher;

    /**
     * 课程描述
     */
    private String description;
}
