package com.github.dwyane.service.impl;

import com.github.dwyane.entity.Role;
import com.github.dwyane.entity.UserRole;
import com.github.dwyane.repository.RoleRepository;
import com.github.dwyane.repository.UserRoleRepository;
import com.github.dwyane.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassNanme: RoleServiceImpl
 * @Description: 角色service
 * @Author: xujinzhao
 * @Date: 2020/2/7 23:38
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
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

    @Override
    public List<Role> findListByUserId(Long userId) {
        List<Role> roleList = new ArrayList<>();
        List<UserRole> userRoleList = userRoleRepository.findByUserId(userId);
        if (!CollectionUtils.isEmpty(userRoleList)) {
            roleList = roleRepository.findByIdIn(
                    userRoleList.stream().map(UserRole::getRoleId).distinct().collect(Collectors.toList()));
        }
        return roleList;
    }
}
