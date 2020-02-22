package com.github.dwyane.service.impl;

import com.github.dwyane.dto.UserDto;
import com.github.dwyane.dto.UserInfoDto;
import com.github.dwyane.entity.Menu;
import com.github.dwyane.entity.Role;
import com.github.dwyane.entity.RoleMenu;
import com.github.dwyane.entity.UserAuth;
import com.github.dwyane.entity.UserInfo;
import com.github.dwyane.entity.UserRole;
import com.github.dwyane.enums.IdentityEnum;
import com.github.dwyane.enums.IdentityTypeEnum;
import com.github.dwyane.exception.CommonException;
import com.github.dwyane.repository.RoleRepository;
import com.github.dwyane.repository.UserAuthRepository;
import com.github.dwyane.repository.UserInfoRepository;
import com.github.dwyane.repository.UserRoleRepository;
import com.github.dwyane.service.MenuService;
import com.github.dwyane.service.RoleService;
import com.github.dwyane.service.UserAuthService;
import com.github.dwyane.service.UserRoleService;
import com.github.dwyane.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassNanme: UserServiceImpl
 * @Description: 用户service
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:28
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserInfoRepository userInfoRepository;

    private final UserRoleRepository userRoleRepository;

    private final UserAuthRepository userAuthRepository;

    private final RoleService roleService;

    private final MenuService menuService;

    @Autowired
    public UserServiceImpl(UserInfoRepository userInfoRepository, RoleService roleService, MenuService menuService,
                           UserRoleRepository userRoleRepository, UserAuthRepository userAuthRepository) {
        this.userInfoRepository = userInfoRepository;
        this.roleService = roleService;
        this.menuService = menuService;
        this.userRoleRepository = userRoleRepository;
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserInfo findById(Long id) {
        return userInfoRepository.findById(id).orElse(null);
    }

    @Override
    public UserInfoDto findUserInfoDto(Integer identityType, String identifier) {
        // 根据唯一表示查询用户授权信息
        UserAuth userAuth = userAuthRepository.
                findOne(Example.of(new UserAuth(identityType, identifier))).orElse(null);
        if (userAuth == null) {
            throw new CommonException("Identifier " + identifier + "does not exist.");
        }

        // 根据用户id查询用户基本信息
        UserInfo userInfo = this.findById(userAuth.getUserId());
        if (userInfo == null) {
            throw new CommonException("Get user info failed, userId = " + userAuth.getUserId());
        }

        // 查询用户的角色信息
        List<Role> roleList = roleService.findListByUserId(userAuth.getUserId());
        // 根据角色查询用户的所有菜单
        List<Menu> menuList = menuService.findListByRoleIds(
                roleList.stream().map(Role::getId).collect(Collectors.toList()));

        // 组装UserInfoDto
        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userAuth, userInfoDto);
        BeanUtils.copyProperties(userInfo, userInfoDto);
        userInfoDto.setRoles(roleList.stream().map(Role::getRoleCode).toArray(String[]::new));
        userInfoDto.setPermissions(menuList.stream().map(Menu::getPermission).toArray(String[]::new));

        // 返回UserInfoDto
        return userInfoDto;
    }

    @Override
    @Transactional
    public Boolean createUser(UserDto userDto) {
        // 保存用户基本信息
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDto, userInfo);
        UserInfo userInfoResult = userInfoRepository.save(userInfo);
        if (userInfoResult == null) {
            log.error("save userInfo fail.");
            return false;
        }

        // 保存用户与角色的映射信息
        userDto.getRole().forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(userInfoResult.getId());
            userRole.setRoleId(roleId);
            userRoleRepository.save(userRole);
        });

        // 保存用户授权信息
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(userInfoResult.getId());
        userAuth.setIdentityType(IdentityTypeEnum.PASSWORD.getValue());
        userAuth.setIdentifier(userDto.getIdentifier());
        userAuth.setCredential(userDto.getCredential());
        UserAuth userAuthResult = userAuthRepository.save(userAuth);
        if (userAuthResult == null) {
            log.info("save userAuth fail.");
            return false;
        }

        return true;
    }

    @Override
    @Transactional
    public Boolean updateUser(UserDto userDto) {
        // 修改用户的基本信息
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userDto, userInfo);
        UserInfo userInfoResult = userInfoRepository.save(userInfo);
        if (userInfoResult == null) {
            log.info("update userInfo fail.");
            return false;
        }

        // 删除原有的角色关系
//        try {
//
//        }
//        userRoleRepository.deleteByUserIdIn(userDto.getId());
        return true;
    }


}
