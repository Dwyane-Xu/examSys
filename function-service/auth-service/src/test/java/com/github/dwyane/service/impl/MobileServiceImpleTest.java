package com.github.dwyane.service.impl;

import com.github.dwyane.client.MsgServiceClient;
import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.exception.FeignException;
import com.github.dwyane.utils.ResultVoUtil;
import com.github.dwyane.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@Slf4j
public class MobileServiceImpleTest {

    @Autowired
    private MsgServiceClient msgServiceClient;

    @Test
    public void sendSms() {
        // 调用消息中心服务，发送短信验证码
        SmsDto smsDto = new SmsDto();
        smsDto.setReceiver("17666522060");
        smsDto.setContent(String.format("{\"code\":\"%s\"}", 1111));
        ResultVo<?> resultVo = msgServiceClient.sendSms(smsDto);
        if (!ResultVoUtil.isSuccess(resultVo)) {
            throw new FeignException("Send validate code error: " + resultVo.getMsg());
        }

        log.info("Send validate result: {}", resultVo.getData());
    }
}