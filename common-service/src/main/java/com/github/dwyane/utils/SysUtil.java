package com.github.dwyane.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

/**
 * @ClassNanme: SysUtil
 * @Description: 系统工具类
 * @Author: xujinzhao
 * @Date: 2020/2/6 22:05
 */
public class SysUtil {

    /**
     * @description 获取当前登录的用户名
     * @author xujinzhao
     * @date 2020/2/8 下午5:42
     */
    public static String getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();
        if (principal instanceof Principal)
            return ((Principal) principal).getName();
        return String.valueOf(principal);
    }
}
