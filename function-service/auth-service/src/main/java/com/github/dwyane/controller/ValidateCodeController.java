package com.github.dwyane.controller;

import com.github.dwyane.constant.RedisKeyConstant;
import com.github.dwyane.constant.RedisTimeConstant;
import com.github.dwyane.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import com.google.code.kaptcha.Producer;

/**
 * @ClassNanme: ValidateCodeController
 * @Description: 验证码controller
 * @Author: xujinzhao
 * @Date: 2020/2/11 17:24
 */
@RestController
@RequestMapping(value = "/code")
public class ValidateCodeController {

    private final Producer kaptchaProducer;

    private final RedisTemplate redisTemplate;

    @Autowired
    public ValidateCodeController(Producer kaptchaProducer, RedisTemplate redisTemplate) {
        this.kaptchaProducer = kaptchaProducer;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/{random}")
    public void produceCode(@PathVariable String random, HttpServletResponse response) throws Exception {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = kaptchaProducer.createText();
        // 生成图片验证码
        BufferedImage imageCode = kaptchaProducer.createImage(text);

        redisTemplate.opsForValue().set(RedisKeyConstant.USER_KAPTCHA + random, text,
                RedisTimeConstant.USER_IMAGE_KAPTCHA, TimeUnit.SECONDS);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(imageCode, "JPEG", out);
    }

    @GetMapping
    public String test() {
        throw new CommonException("test");
    }
}
