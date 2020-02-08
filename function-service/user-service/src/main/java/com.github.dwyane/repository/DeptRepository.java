package com.github.dwyane.repository;

import com.github.dwyane.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassNanme: DeptRepository
 * @Description: 部门repository
 * @Author: xujinzhao
 * @Date: 2020/2/6 17:36
 */
public interface DeptRepository extends JpaRepository<Dept, Long> {

}
