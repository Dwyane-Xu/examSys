package com.github.dwyane.client;

import com.github.dwyane.client.factory.MsgServiceClientFallbackFactory;
import com.github.dwyane.config.CustomFeignConfig;
import com.github.dwyane.constant.ServiceConstant;
import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ClassNanme: MsgServiceClient
 * @Description: msg-service client
 * @Author: xujinzhao
 * @Date: 2020/2/12 22:37
 */
@FeignClient(value = ServiceConstant.MSG_SERVICE, configuration = CustomFeignConfig.class,
        fallbackFactory = MsgServiceClientFallbackFactory.class)
public interface MsgServiceClient {

    @PostMapping("/msg/sms/sendSms")
    ResultVo<?> sendSms(@RequestBody SmsDto smsDto);
}
