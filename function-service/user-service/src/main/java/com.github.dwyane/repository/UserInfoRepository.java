package com.github.dwyane.repository;

import com.github.dwyane.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassNanme: UserInfoRepository
 * @Description: 用户信息repository
 * @Author: xujinzhao
 * @Date: 2020/2/20 16:18
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
