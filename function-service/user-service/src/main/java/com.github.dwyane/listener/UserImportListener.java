package com.github.dwyane.listener;

import com.github.dwyane.dto.UserInfoDto;
import com.github.dwyane.excel.listener.AbstractExcelImportListener;
import com.github.dwyane.service.UserService;
import com.github.dwyane.vo.UserExcelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNanme: UserImportListener
 * @Description: Excel导入用户数据
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:27
 */
@Slf4j
public class UserImportListener extends AbstractExcelImportListener<UserExcelVo> {

    private UserService userService;

    public UserImportListener(UserService userService) {
        this.userService = userService;
    }

    /**
     * 存储到数据库
     */
    @Override
    public void saveData(List<UserExcelVo> userExcelModels) {
        log.info("SaveData size: {}", userExcelModels.size());
        List<UserInfoDto> userInfoDtoList = new ArrayList<>(userExcelModels.size());
        userExcelModels.forEach(data -> {
            UserInfoDto userInfoDto = new UserInfoDto();
            BeanUtils.copyProperties(data, userInfoDto);
            userInfoDtoList.add(userInfoDto);
        });
//        userService.importUsers(userInfoDtoList);
    }
}
