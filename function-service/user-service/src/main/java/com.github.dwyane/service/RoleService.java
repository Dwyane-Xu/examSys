package com.github.dwyane.service;

import com.github.dwyane.entity.Role;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ClassNanme: RoleService
 * @Description: 角色service
 * @Author: xujinzhao
 * @Date: 2020/2/7 23:38
 */
public interface RoleService {

    Role findById(Long id);

    PageImpl<Role> findPage(Pageable pageable);

    Role save(Role role);

    void deleteById(Long id);

    void deleteList(Long[] ids);

    /**
     * 根据用户id获取用户的角色
     */
    List<Role> findListByUserId(Long userId);
}
