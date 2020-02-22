package com.github.dwyane.repository;

import com.github.dwyane.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassNanme: UserRoleRepository
 * @Description: 用户角色repository
 * @Author: xujinzhao
 * @Date: 2020/2/21 03:36
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Long userId);

    void deleteByUserId(Long userId);
}
