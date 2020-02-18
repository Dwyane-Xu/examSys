package com.github.dwyane.controller;

import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.service.SmsService;
import com.github.dwyane.utils.ResultVoUtil;
import com.github.dwyane.vo.ResultVo;
import com.github.dwyane.vo.SmsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNanme: SmsController
 * @Description: 发送短信controller
 * @Author: xujinzhao
 * @Date: 2020/2/12 03:06
 */
@Slf4j
@RestController
@RequestMapping(value = "/sms")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/sendSms")
    public ResultVo<SmsVo> sendSms(@RequestBody SmsDto smsDto) {
        log.info("Send message to {}, content: {}", smsDto.getReceiver(), smsDto.getContent());
        SmsVo smsVo = smsService.sendSms(smsDto);
        log.info("Send message success, response: {}", smsVo);
        return ResultVoUtil.success(smsVo);
    }
}
