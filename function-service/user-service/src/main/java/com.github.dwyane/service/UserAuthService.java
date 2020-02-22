package com.github.dwyane.service;

import com.github.dwyane.entity.UserAuth;

import java.util.List;

/**
 * @ClassNanme: UserAuthService
 * @Description: 用户授权service
 * @Author: xujinzhao
 * @Date: 2020/2/20 16:32
 */
public interface UserAuthService {

    List<UserAuth> findListByUserIds(List<Long> userIds);

    Boolean deleteByIdentifier(String identifier);

    Boolean deleteByUserId(Long userId);

    Boolean saveAll(List<UserAuth> userAuthList);
}
