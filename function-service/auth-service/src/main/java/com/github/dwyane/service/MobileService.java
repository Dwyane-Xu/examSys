package com.github.dwyane.service;

import com.github.dwyane.vo.ResultVo;

/**
 * @ClassNanme: MobileService
 * @Description: 手机相关service
 * @Author: xujinzhao
 * @Date: 2020/2/12 21:42
 */
public interface MobileService {

    ResultVo sendSms(String mobile);
}
