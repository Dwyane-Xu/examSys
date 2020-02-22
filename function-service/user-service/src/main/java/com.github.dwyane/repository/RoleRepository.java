package com.github.dwyane.repository;

import com.github.dwyane.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassNanme: RoleRepository
 * @Description: 角色repository
 * @Author: xujinzhao
 * @Date: 2020/2/7 23:36
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Modifying
    @Transactional
    @Query("delete from Role r where r.id in (?1)")
    void deleteByIds(List<Long> ids);

    List<Role> findByIdIn(List<Long> ids);

    List<Role> findByIsDefault(Integer isDefault);
}
