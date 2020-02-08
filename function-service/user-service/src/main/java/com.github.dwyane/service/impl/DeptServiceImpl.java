package com.github.dwyane.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.dto.DeptDto;
import com.github.dwyane.entity.Dept;
import com.github.dwyane.repository.DeptRepository;
import com.github.dwyane.service.DeptService;
import com.github.dwyane.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassNanme: DeptServiceImpl
 * @Description: 部门相关service
 * @Author: xujinzhao
 * @Date: 2020/2/6 17:40
 */
@Service
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    @Autowired
    public DeptServiceImpl(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }

    @Override
    public Dept findById(Long id) {
        return deptRepository.findById(id).orElse(new Dept());
    }

    @Override
    public List<DeptDto> findList() {
        List<Dept> deptList = deptRepository.findAll();
        if (!CollectionUtils.isEmpty(deptList)) {
            List<DeptDto> deptDtoList = deptList.stream().map(DeptDto::new).collect(Collectors.toList());
            return TreeUtil
                    .buildTree(CollUtil.sort(deptDtoList, Comparator.comparingInt(DeptDto::getSort)), CommonConstant.ROOT);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Dept save(Dept dept) {
        return deptRepository.save(dept);
    }

    @Override
    public void deleteById(Long id) {
        deptRepository.deleteById(id);
    }
}
