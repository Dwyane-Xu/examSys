package com.github.dwyane.handler;

import com.github.dwyane.constant.ApiMsg;
import com.github.dwyane.exception.CommonException;
import com.github.dwyane.vo.ResponseBean;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
        ResponseBean<List<String>> responseBean = new ResponseBean<>(errors, ApiMsg.KEY_SERVICE, ApiMsg.ERROR);
        return new ResponseEntity<>(responseBean, headers, status);
    }

    /**
     * 处理CommonException
     */
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ResponseBean<String>> handleCommonException(Exception e) {
        ResponseBean<String> responseBean = new ResponseBean<>(e.getMessage(), ApiMsg.KEY_SERVICE, ApiMsg.ERROR);
        return new ResponseEntity<>(responseBean, HttpStatus.OK);
    }
}
