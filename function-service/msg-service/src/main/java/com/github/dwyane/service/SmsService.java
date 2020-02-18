package com.github.dwyane.service;

import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.vo.SmsVo;

/**
 * @ClassNanme: SmsService
 * @Description: 发送短信service
 * @Author: xujinzhao
 * @Date: 2020/2/12 03:07
 */
public interface SmsService {

    SmsVo sendSms(SmsDto smsDto);
}
