package com.github.dwyane.utils;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;

import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Principal;

/**
 * @ClassNanme: SysUtil
 * @Description: 系统工具类
 * @Author: xujinzhao
 * @Date: 2020/2/6 22:05
 */
public class SysUtil {

    private static final String KEY_ALGORITHM = "AES";

    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/NOPadding";

    /**
     * @description 获取当前登录的用户名
     * @author xujinzhao
     * @date 2020/2/8 下午5:42
     */
    public static String getUser() {
        /*
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();
        if (principal instanceof Principal)
            return ((Principal) principal).getName();
        return String.valueOf(principal);
        */
        return "test";
    }

    public static String decryptAES(String data, String pass) throws Exception {
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(pass.getBytes(), KEY_ALGORITHM), new IvParameterSpec(pass.getBytes()));
        byte[] result = cipher.doFinal(Base64.decode(data.getBytes(StandardCharsets.UTF_8)));
        return new String(result, StandardCharsets.UTF_8);
    }
}
