package com.github.dwyane.dto;

import lombok.Data;

/**
 * @ClassNanme: SmsDto
 * @Description: 发送内容
 * @Author: xujinzhao
 * @Date: 2020/2/12 14:30
 */
@Data
public class SmsDto {

    /**
     * 接收人
     */
    private String receiver;

    /**
     * 发送内容
     */
    private String content;
}
