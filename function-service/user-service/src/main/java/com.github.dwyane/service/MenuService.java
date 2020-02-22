package com.github.dwyane.service;

import com.github.dwyane.dto.MenuDto;
import com.github.dwyane.entity.Menu;
import com.github.dwyane.entity.Role;

import java.util.List;

/**
 * @ClassNanme: MenuService
 * @Description: 菜单service
 * @Author: xujinzhao
 * @Date: 2020/2/16 16:02
 */
public interface MenuService {

    List<MenuDto> findTreeList();

    List<MenuDto> findUserTreeList();

    Menu findById(Long id);

    Menu save(Menu menu);

    Menu update(Menu menu);

    void deleteById(Long id);

    /**
     * 获取角色们的所有菜单
     */
    List<Menu> findListByRoleIds(List<Long> roleIds);
}
