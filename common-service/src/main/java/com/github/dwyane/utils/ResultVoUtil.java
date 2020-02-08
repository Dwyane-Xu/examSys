package com.github.dwyane.utils;

import com.github.dwyane.vo.ResultVo;
import com.github.dwyane.enums.ResultEnum;

/**
 * @ClassNanme: ResultVoUtil
 * @Description: 处理controller层返回值工具类
 * @Author: xujinzhao
 * @Date: 2020/2/7 01:47
 */
public class ResultVoUtil {

    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVo error(ResultEnum resultEnum, Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVo error(ResultEnum resultEnum) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }
}
