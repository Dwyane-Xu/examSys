package com.github.dwyane.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.github.dwyane.client.MsgServiceClient;
import com.github.dwyane.constant.CommonConstant;
import com.github.dwyane.constant.RedisKeyConstant;
import com.github.dwyane.constant.RedisTimeConstant;
import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.exception.FeignException;
import com.github.dwyane.service.MobileService;
import com.github.dwyane.utils.ResultVoUtil;
import com.github.dwyane.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassNanme: MobileServiceImple
 * @Description: 手机相关service
 * @Author: xujinzhao
 * @Date: 2020/2/12 21:42
 */
@Slf4j
@Service
public class MobileServiceImple implements MobileService {

    private final RedisTemplate redisTemplate;

    private final MsgServiceClient msgServiceClient;

    @Autowired
    public MobileServiceImple(RedisTemplate redisTemplate, MsgServiceClient msgServiceClient) {
        this.redisTemplate = redisTemplate;
        this.msgServiceClient = msgServiceClient;
    }

    public ResultVo sendSms(String mobile) {
        // 生成验证码保存到redis中
        String key =  RedisKeyConstant.USER_KAPTCHA + mobile;
        String code = RandomUtil.randomNumbers(Integer.parseInt(CommonConstant.CODE_SIZE));
        log.info("Generate validate code success: {}, {}", mobile, code);

        // 调用消息中心服务，发送短信验证码
        SmsDto smsDto = new SmsDto();
        smsDto.setReceiver(mobile);
        smsDto.setContent(String.format("{\"code\":\"%s\"}", code));
        ResultVo<?> resultVo = msgServiceClient.sendSms(smsDto);
        log.info("Send validate result: {}", resultVo.getData());
        if (!ResultVoUtil.isSuccess(resultVo)) {
            throw new FeignException("Send validate code error: " + resultVo.getMsg());
        }

        redisTemplate.opsForValue().set(key, code, RedisTimeConstant.USER_SMS_KAPTCHA, TimeUnit.SECONDS);
        log.info("Send validate result: {}", resultVo.getData());
        return ResultVoUtil.success();
    }
}
