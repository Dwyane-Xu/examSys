package com.github.dwyane.client.fallback;

import com.github.dwyane.client.UserServiceClient;
import com.github.dwyane.dto.UserDto;
import com.github.dwyane.dto.UserInfoDto;
import com.github.dwyane.entity.Menu;
import com.github.dwyane.vo.DeptVo;
import com.github.dwyane.vo.ResponseBean;
import com.github.dwyane.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassNanme: UserServiceClientFallback
 * @Description: 日志断路器实现
 * @Author: xujinzhao
 * @Date: 2020/2/18 23:59
 */
@Slf4j
@Component
public class UserServiceClientFallback implements UserServiceClient {

    private Throwable throwable;

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public ResponseBean<UserVo> findUserByIdentifier(String identifier, String tenantCode) {
        return null;
    }

    @Override
    public ResponseBean<UserVo> findUserByIdentifier(String identifier, Integer identityType, String tenantCode) {
        return null;
    }

    @Override
    public ResponseBean<UserInfoDto> info() {
        return null;
    }

    @Override
    public ResponseBean<List<UserVo>> findUserById(Long[] ids) {
        return null;
    }

    @Override
    public ResponseBean<Integer> findUserCount(UserVo userVo) {
        return null;
    }

    @Override
    public ResponseBean<List<DeptVo>> findDeptById(Long[] ids) {
        return null;
    }

    @Override
    public ResponseBean<Boolean> deleteAttachment(Long id) {
        return null;
    }

    @Override
    public ResponseBean<List<Menu>> findMenuByRole(String role, String tenantCode) {
        return null;
    }

    @Override
    public ResponseBean<List<Menu>> findAllMenu(String tenantCode) {
        return null;
    }

    @Override
    public ResponseBean<UserVo> findUserBySocial(String social, String tenantCode) {
        return null;
    }

    @Override
    public ResponseBean<Boolean> registerUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseBean<Boolean> updateUser(UserDto userDto) {
        return null;
    }
}
