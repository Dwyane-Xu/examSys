package com.github.dwyane.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassNanme: CustomAuthenticationFailureEvent
 * @Description: 登录失败事件
 * @Author: xujinzhao
 * @Date: 2020/2/19 11:44
 */
@Data
public class CustomAuthenticationFailureEvent extends ApplicationEvent {

    private UserDetails userDetails;

    public CustomAuthenticationFailureEvent(Authentication authentication, UserDetails userDetails) {
        super(authentication);
        this.userDetails = userDetails;
    }

}
