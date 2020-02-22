package com.github.dwyane.repository;

import com.github.dwyane.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @ClassNanme: UserAuthRepository
 * @Description: 用户授权repository
 * @Author: xujinzhao
 * @Date: 2020/2/20 16:31
 */
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    Optional<UserAuth> findByIdentifier(String identifier);

    List<UserAuth> findByUserIdIn(List<Long> userIds);

    void deleteByIdentifier(String identifier);

    void deleteByUserId(Long userId);
}
