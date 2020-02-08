package com.github.dwyane.service.impl;

import com.github.dwyane.entity.Role;
import com.github.dwyane.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    RoleService roleService;

    @Test
    public void findById() {
    }

    @Test
    public void findPage() {
    }

    @Test
    public void save() {
        Role role = new Role();
//        role.setId(3L);
        role.setRoleName("管理员");
        role.setRoleCode("role_admin");
        role.setRoleDesc("管理员");
        role.setStatus(0);
        roleService.save(role);
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void deleteList() {
        roleService.deleteList(new Long[]{3L});
    }
}