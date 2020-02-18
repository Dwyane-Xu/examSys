package com.github.dwyane.service.impl;

import com.github.dwyane.entity.Menu;
import com.github.dwyane.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void findTreeList() {
    }

    @Test
    public void findUserTreeList() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
        Menu menu = new Menu();
        menuService.save(menu);
        System.out.println(menu);
    }

    @Test
    public void deleteById() {
    }
}