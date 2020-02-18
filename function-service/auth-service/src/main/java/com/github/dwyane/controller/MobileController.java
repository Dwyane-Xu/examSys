package com.github.dwyane.controller;

import com.github.dwyane.service.MobileService;
import com.github.dwyane.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNanme: MobileController
 * @Description: 手机相关contrller
 * @Author: xujinzhao
 * @Date: 2020/2/12 21:39
 */
@Slf4j
@RestController
@RequestMapping("/mobile")
public class MobileController {

    private final MobileService mobileService;

    @Autowired
    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @GetMapping("/{mobile}")
    public ResultVo sendSms(@PathVariable String mobile) {
        return mobileService.sendSms(mobile);
    }
}
