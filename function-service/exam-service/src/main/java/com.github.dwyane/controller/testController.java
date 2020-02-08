package com.github.dwyane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNanme: testController
 * @Description:
 * @Author: xujinzhao
 * @Date: 2020/2/5 13:46
 */
@RestController
@RequestMapping
public class testController {

    @GetMapping("/aaa")
    public String test() {
        return "success";
    }

}
