package com.github.dwyane.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassNanme: CustomAuthenticationSuccessEvent
 * @Description: 登录成功事件
 * @Author: xujinzhao
 * @Date: 2020/2/19 11:44
 */
@Data
public class CustomAuthenticationSuccessEvent extends ApplicationEvent {

    private UserDetails userDetails;

    public CustomAuthenticationSuccessEvent(Authentication authentication, UserDetails userDetails) {
        super(authentication);
        this.userDetails = userDetails;
    }
}
