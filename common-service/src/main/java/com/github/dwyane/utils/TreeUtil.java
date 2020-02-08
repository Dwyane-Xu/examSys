package com.github.dwyane.utils;

import com.github.dwyane.entity.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNanme: TreeUtil
 * @Description: 树形相关工具类
 * @Author: xujinzhao
 * @Date: 2020/2/6 22:13
 */
public class TreeUtil {

    /**
     * @description 两层循环实现建树
     * @param treeEntities 传入的树实体列表
     * @param root         树根的值
     * @author xujinzhao
     * @date 2020/2/6 下午10:14
     */
    public static <T> List<T> buildTree(List<? extends TreeEntity<T>> treeEntities, Object root) {
        List<TreeEntity<T>> treeUtilList = new ArrayList<>();
        treeEntities.forEach(treeEntity -> {
            if (treeEntity.getParentId().equals(root)) {
                treeUtilList.add(treeEntity);
            }
            treeEntities.forEach(treeChildEntity -> {
                if (treeChildEntity.getParentId().equals(treeEntity.getId())) {
                    treeEntity.add(treeChildEntity);
                }
            });
        });

        return (List<T>) treeUtilList;
    }
}
