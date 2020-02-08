package com.github.dwyane.service;

import com.github.dwyane.dto.DeptDto;
import com.github.dwyane.entity.Dept;

import java.util.List;

/**
 * @ClassNanme: DeptService
 * @Description: 部门相关service
 * @Author: xujinzhao
 * @Date: 2020/2/6 17:37
 */
public interface DeptService {

    Dept findById(Long id);

    List<DeptDto> findList();

    Dept save(Dept dept);

    void deleteById(Long id);
}
