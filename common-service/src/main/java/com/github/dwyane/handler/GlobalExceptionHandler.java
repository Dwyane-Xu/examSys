package com.github.dwyane.handler;

import com.github.dwyane.vo.ResultVo;
import com.github.dwyane.enums.ResultEnum;
import com.github.dwyane.utils.ResultVoUtil;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassNanme: GlobalExceptionHandler
 * @Description: 全局异常处理
 * @Author: xujinzhao
 * @Date: 2020/2/7 16:58
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * 处理参数异常
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        // 获取所有异常信息
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ResultVo<List<String>> resultVO = ResultVoUtil.error(ResultEnum.PARAM_ERROR, errors);
        return new ResponseEntity<>(resultVO, headers, status);
    }
}
