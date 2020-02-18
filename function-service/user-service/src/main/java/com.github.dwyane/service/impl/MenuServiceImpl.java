package com.github.dwyane.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.dto.MenuDto;
import com.github.dwyane.entity.Menu;
import com.github.dwyane.properties.SysProperties;
import com.github.dwyane.repository.MenuRepository;
import com.github.dwyane.service.MenuService;
import com.github.dwyane.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassNanme: MenuServiceImpl
 * @Description: 菜单service
 * @Author: xujinzhao
 * @Date: 2020/2/16 16:02
 */
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final SysProperties sysProperties;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, SysProperties sysProperties) {
        this.menuRepository = menuRepository;
        this.sysProperties = sysProperties;
    }

    @Override
    public List<MenuDto> findTreeList() {
        List<Menu> menuList = menuRepository.findAll();
        if (!CollectionUtils.isEmpty(menuList)) {
            List<MenuDto> menuDtoList = menuList.stream().map(MenuDto::new).collect(Collectors.toList());
            return TreeUtil
                    .buildTree(CollUtil.sort(menuDtoList, Comparator.comparingInt(MenuDto::getSort)), CommonConstant.ROOT);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<MenuDto> findUserTreeList() {
        List<Menu> menuList = menuRepository.findAll();

        return null;
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElse(new Menu());
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu update(Menu menu) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }
}
