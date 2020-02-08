package com.github.dwyane.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNanme: TreeEntity
 * @Description: 树形实体
 * @Author: xujinzhao
 * @Date: 2020/2/6 20:40
 */
@Data
public abstract class TreeEntity<T> {

    protected Long id;

    /**
     * 父节点
     */
    protected T parent;

    /**
     * 父节点id
     */
    protected Long parentId;

    /**
     * 排序号
     */
    protected Integer sort;

    /**
     * 子节点
     */
    protected List<TreeEntity> children = new ArrayList<>();

    /**
     * 添加子节点
     */
    public void add(TreeEntity node) {
        children.add(node);
    }
}
