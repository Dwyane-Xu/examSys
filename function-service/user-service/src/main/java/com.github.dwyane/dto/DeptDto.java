package com.github.dwyane.dto;

import com.github.dwyane.entity.Dept;
import com.github.dwyane.entity.TreeEntity;
import lombok.Data;

/**
 * @ClassNanme: DeptDto
 * @Description: 树形部门dto
 * @Author: xujinzhao
 * @Date: 2020/2/6 20:46
 */
@Data
public class DeptDto extends TreeEntity<DeptDto> {

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门描述
     */
    private String deptDesc;

    /**
     * 部门负责人
     */
    private String deptLeader;

    public DeptDto(Dept dept) {
        this.id = dept.getId();
        this.deptName = dept.getDeptName();
        this.deptDesc = dept.getDeptDesc();
        this.deptLeader = dept.getDeptLeader();
        this.parentId = dept.getParentId();
        this.sort = dept.getSort();
    }
}
