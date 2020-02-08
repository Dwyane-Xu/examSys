package com.github.dwyane.vo;

import lombok.Data;

/**
 * @ClassNanme: ResultVo
 * @Description: http请求返回的最外层对象
 * @Author: xujinzhao
 * @Date: 2020/2/5 17:09
 */
@Data
public class ResultVo<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
