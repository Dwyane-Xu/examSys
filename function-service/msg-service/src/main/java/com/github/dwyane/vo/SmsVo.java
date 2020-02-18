package com.github.dwyane.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassNanme: SmsVo
 * @Description: 封装短信服务返回的结果
 * @Author: xujinzhao
 * @Date: 2020/2/12 03:09
 */
@Data
public class SmsVo implements Serializable {

    private static final long serialVersionUID = -2404325680591451984L;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("RequestId")
    private String requestId;

    @JsonProperty("BizId")
    private String bizId;

    @JsonProperty("Code")
    private String code;
}
