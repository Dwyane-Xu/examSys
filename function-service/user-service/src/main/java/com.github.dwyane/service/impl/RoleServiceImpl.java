package com.github.dwyane.service.impl;

import com.github.dwyane.entity.Role;
import com.github.dwyane.repository.RoleRepository;
import com.github.dwyane.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @ClassNanme: RoleServiceImpl
 * @Description: 角色service
 * @Author: xujinzhao
 * @Date: 2020/2/7 23:38
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(new Role());
    }

    @Override
    public PageImpl<Role> findPage(Pageable pageable) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void deleteList(Long[] ids) {
        roleRepository.deleteByIds(Arrays.asList(ids));
    }
}
