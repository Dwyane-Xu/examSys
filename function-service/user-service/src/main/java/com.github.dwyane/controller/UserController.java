package com.github.dwyane.controller;

import com.github.dwyane.dto.UserDto;
import com.github.dwyane.dto.UserInfoDto;
import com.github.dwyane.entity.Role;
import com.github.dwyane.entity.UserInfo;
import com.github.dwyane.exception.CommonException;
import com.github.dwyane.service.UserService;
import com.github.dwyane.vo.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassNanme: UserController
 * @Description: 用户controller
 * @Author: xujinzhao
 * @Date: 2020/2/20 15:52
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseBean<UserInfo> findById(@PathVariable Long id) {
        UserInfo userInfo = userService.findById(id);
        if (userInfo != null) {
            return new ResponseBean<>(userInfo);
        } else {
            log.info("find user by id failed, userId: {}", id);
            return new ResponseBean<>(new UserInfo());
        }
    }

    @GetMapping("/info")
    public ResponseBean<UserInfoDto> findUserInfo(@RequestParam(required = false) String identityType,
                                                  OAuth2Authentication authentication) {
        try {
            UserInfoDto userInfoDto = userService.findUserInfoDto(Integer.valueOf(identityType),
                    authentication.getName());
            return new ResponseBean<>(userInfoDto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CommonException("获取当前登录用户详细信息失败");
        }
    }

    @GetMapping("/listPage")
    public ResponseBean<PageImpl<Role>> findPage() {
        return null;
    }

    @PostMapping
    public ResponseBean<Boolean> createUser(@RequestBody @Valid UserDto userDto) {
        try {
            return new ResponseBean<>(userService.createUser(userDto));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CommonException("创建用户失败");
        }
    }

    @PutMapping
    public ResponseBean<Boolean> updateUser(@RequestBody @Valid UserDto userDto) {
        return null;
    }
}
