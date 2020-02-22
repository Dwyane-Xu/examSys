package com.github.dwyane.service;

import com.github.dwyane.entity.Menu;
import com.github.dwyane.entity.RoleMenu;

import java.util.List;

/**
 * @ClassNanme: RoleMenuService
 * @Description: 角色菜单service
 * @Author: xujinzhao
 * @Date: 2020/2/16 17:22
 */
public interface RoleMenuService {

    List<RoleMenu> findListByMenuIds(List<Long> menuIds);

    Boolean updateMenuIdsByRoleId(Long roleId, List<Long> menuIds);
}
