package com.github.dwyane.service.impl;

import com.github.dwyane.entity.RoleMenu;
import com.github.dwyane.repository.RoleMenuRepository;
import com.github.dwyane.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNanme: RoleMenuServiceImpl
 * @Description: 角色菜单service
 * @Author: xujinzhao
 * @Date: 2020/2/16 17:22
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    private final RoleMenuRepository roleMenuRepository;

    @Autowired
    public RoleMenuServiceImpl(RoleMenuRepository roleMenuRepository) {
        this.roleMenuRepository = roleMenuRepository;
    }

    @Override
    public List<RoleMenu> findListByMenuIds(List<Long> menuIds) {
        return roleMenuRepository.findByMenuIdIn(menuIds);
    }

    @Override
    public Boolean updateMenuIdsByRoleId(Long roleId, List<Long> menuIds) {
        if (!CollectionUtils.isEmpty(menuIds)) {
            // 先删除，后添加策略
            roleMenuRepository.deleteById(roleId);
            List<RoleMenu> roleMenuList = new ArrayList<>();
            for (Long menuId : menuIds) {
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menuId);
                roleMenuList.add(roleMenu);
            }
            roleMenuRepository.saveAll(roleMenuList);
            return true;
        } else {
            return false;
        }
    }
}
