package com.github.dwyane.repository;

import com.github.dwyane.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassNanme: RoleMenuRepository
 * @Description: 角色菜单repository
 * @Author: xujinzhao
 * @Date: 2020/2/16 17:33
 */
public interface RoleMenuRepository extends JpaRepository<RoleMenu, Long> {

    List<RoleMenu> findByMenuIdIn(List<Long> menuIds);

    List<RoleMenu> findByRoleIdIn(List<Long> roleIds);
}
