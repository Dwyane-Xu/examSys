package com.github.dwyane.listener;

import com.github.dwyane.entity.Menu;
import com.github.dwyane.excel.listener.AbstractExcelImportListener;
import com.github.dwyane.service.MenuService;
import com.github.dwyane.vo.MenuExcelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNanme: MenuImportListener
 * @Description: Excel导入菜单数据
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:38
 */
@Slf4j
public class MenuImportListener extends AbstractExcelImportListener<MenuExcelVo> {

    private MenuService menuService;

    public MenuImportListener(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public void saveData(List<MenuExcelVo> menuExcelModels) {
        log.info("SaveData size: {}", menuExcelModels.size());
        List<Menu> menuList = new ArrayList<>(menuExcelModels.size());
        menuExcelModels.forEach(data -> {
            Menu menu = new Menu();
            BeanUtils.copyProperties(data, menu);
            menuList.add(menu);
        });
        menuList.forEach(menu -> {
            menuService.save(menu);
        });
    }
}
