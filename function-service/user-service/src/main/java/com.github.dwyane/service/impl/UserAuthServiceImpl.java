package com.github.dwyane.service.impl;

import com.github.dwyane.entity.UserAuth;
import com.github.dwyane.repository.UserAuthRepository;
import com.github.dwyane.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassNanme: UserAuthServiceImpl
 * @Description: 用户授权service
 * @Author: xujinzhao
 * @Date: 2020/2/20 16:32
 */
@Slf4j
@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public List<UserAuth> findListByUserIds(List<Long> userIds) {
        return userAuthRepository.findByUserIdIn(userIds);
    }

    @Override
    public Boolean deleteByIdentifier(String identifier) {
        try {
            userAuthRepository.deleteByIdentifier(identifier);
            return true;
        } catch (Exception e) {
            log.error("Delete userAuth By Identifier, identifier: {}", identifier, e);
            return false;
        }
    }

    @Override
    public Boolean deleteByUserId(Long userId) {
        try {
            userAuthRepository.deleteByUserId(userId);
            return true;
        } catch (Exception e) {
            log.error("Delete userAuth By UserId, userId: {}", userId, e);
            return false;
        }
    }

    @Override
    public Boolean saveAll(List<UserAuth> userAuthList) {
        try {
            userAuthRepository.saveAll(userAuthList);
            return true;
        } catch (Exception e) {
            log.error("Save userAuthList", e);
            return false;
        }
    }
}
