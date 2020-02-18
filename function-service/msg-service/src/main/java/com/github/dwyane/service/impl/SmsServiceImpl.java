package com.github.dwyane.service.impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.github.dwyane.dto.SmsDto;
import com.github.dwyane.exception.SmsException;
import com.github.dwyane.properties.SmsProperties;
import com.github.dwyane.service.SmsService;
import com.github.dwyane.utils.JsonUtil;
import com.github.dwyane.vo.SmsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNanme: SmsServiceImpl
 * @Description: 发送短信service
 * @Author: xujinzhao
 * @Date: 2020/2/12 03:07
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    private final SmsProperties smsProperties;

    @Autowired
    public SmsServiceImpl(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
    }

    /**
     * 发送短信
     */
    public SmsVo sendSms(SmsDto smsDto) {
        DefaultProfile profile = DefaultProfile.getProfile(smsProperties.getRegionId(),
                smsProperties.getAppKey(), smsProperties.getAppSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        // 设置请求request
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(smsProperties.getDomain());
        request.putQueryParameter("RegionId", smsProperties.getRegionId());
        request.putQueryParameter("PhoneNumbers", smsDto.getReceiver());
        request.putQueryParameter("SignName", smsProperties.getSignName());
        request.putQueryParameter("TemplateCode", smsProperties.getTemplateCode());
        request.putQueryParameter("TemplateParam", smsDto.getContent());
        request.setVersion(smsProperties.getVersion());
        request.setAction(smsProperties.getAction());

        // 获取结果response
        try {
            // 请求异常
            CommonResponse response = client.getCommonResponse(request);
            log.info("response: {}", response.getData());
            if (response.getHttpStatus() != 200) {
                throw new SmsException(response.getData());
            }

            // 数据异常
            SmsVo smsVo = JsonUtil.fromJson(response.getData(), SmsVo.class);
            if (smsVo == null) {
                throw new SmsException("Parse response error");
            }

            // 其它异常
            if (!"OK".equals(smsVo.getCode())) {
                throw new SmsException(smsVo.getMessage());
            }

            // 无异常
            return smsVo;
        } catch (Exception e) {
            // 发送异常
            log.error(e.getMessage(), e);
            throw new SmsException("Send message failed: " + e.getMessage());
        }
    }
}
