package com.github.dwyane.controller;

import com.github.dwyane.dto.MenuDto;
import com.github.dwyane.entity.Menu;
import com.github.dwyane.service.MenuService;
import com.github.dwyane.vo.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassNanme: MenuController
 * @Description: 菜单controller
 * @Author: xujinzhao
 * @Date: 2020/2/16 23:14
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public ResponseBean<List<MenuDto>> findTreeList() {
        return new ResponseBean<>(menuService.findTreeList());
    }

    @GetMapping("/list/user")
    public ResponseBean<List<MenuDto>> findUserTreeList() {
        return new ResponseBean<>(menuService.findUserTreeList());
    }

    @GetMapping("/{id}")
    public ResponseBean<Menu> findById(@PathVariable Long id) {
        return new ResponseBean<>(menuService.findById(id));
    }

    @PostMapping
    public ResponseBean<Boolean> add(@RequestBody @Valid Menu menu) {
        menuService.save(menu);
        return new ResponseBean<>(true);
    }

    @PutMapping
    public ResponseBean<Boolean> update(@RequestBody @Valid Menu menu) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseBean<Boolean> deleteById(@PathVariable Long id) {
        menuService.deleteById(id);
        return new ResponseBean<>(true);
    }
}
