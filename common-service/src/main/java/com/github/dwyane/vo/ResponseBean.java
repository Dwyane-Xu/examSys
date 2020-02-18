package com.github.dwyane.vo;

import com.github.dwyane.constant.ApiMsg;
import com.github.dwyane.enums.ResultEnum;
import lombok.Data;

/**
 * @ClassNanme: ResponseBean
 * @Description: 封装返回数据
 * @Author: xujinzhao
 * @Date: 2020/2/15 01:11
 */
@Data
public class ResponseBean<T> {

    private String msg = ApiMsg.msg(ApiMsg.KEY_SUCCESS);

    private int code = ApiMsg.KEY_SUCCESS;

    private T data;

    public ResponseBean() {
        super();
    }

    public ResponseBean(T data) {
        super();
        this.data = data;
    }

    public ResponseBean(T data, int keyCode, int msgCode) {
        super();
        this.data = data;
        this.code = Integer.parseInt(keyCode + "" + msgCode);
        this.msg = ApiMsg.code2Msg(keyCode, msgCode);
    }

    public ResponseBean(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }
}
