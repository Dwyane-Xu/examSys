package com.github.dwyane.service.impl;

import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.service.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsServiceImplTest {

    @Autowired
    private SmsService smsService;

    @Test
    public void sendSms() {
        SmsDto smsDto = new SmsDto();
        smsDto.setReceiver("17666522060");
        smsDto.setContent("{\"code\":\"1111\"}	");
        smsService.sendSms(smsDto);
    }
}