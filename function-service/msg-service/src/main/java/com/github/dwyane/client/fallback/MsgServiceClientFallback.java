package com.github.dwyane.client.fallback;

import com.github.dwyane.client.MsgServiceClient;
import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.utils.ResultVoUtil;
import com.github.dwyane.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @ClassNanme: MsgServiceClientFallback
 * @Description: msg-service client fallback
 * @Author: xujinzhao
 * @Date: 2020/2/12 22:45
 */
@Slf4j
@Component
public class MsgServiceClientFallback implements MsgServiceClient {

    private Throwable throwable;

    @Override
    public ResultVo<?> sendSms(SmsDto smsDto) {
        log.error("Feign send message failed: {}, {}, {}", smsDto.getReceiver(), smsDto.getContent(), throwable);
        return null;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
