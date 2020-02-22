package com.github.dwyane.service;

import com.github.dwyane.dto.UserDto;
import com.github.dwyane.dto.UserInfoDto;
import com.github.dwyane.entity.UserInfo;

/**
 * @ClassNanme: UserService
 * @Description: 用户service
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:28
 */
public interface UserService {

    /**
     * 根据用户id查询用户基本信息
     */
    UserInfo findById(Long id);

    /**
     * 获取用户详细信息，包括头像、角色、权限信息
     */
    UserInfoDto findUserInfoDto(Integer identityType, String identifier);

    /**
     * 新增用户
     */
    Boolean createUser(UserDto userDto);

    /**
     * 修改用户信息
     */
    Boolean updateUser(UserDto userDto);
}
