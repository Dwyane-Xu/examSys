package com.github.dwyane.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassNanme: LogValue
 * @Description: 日志注解
 * @Author: xujinzhao
 * @Date: 2020/2/18 21:46
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogValue {
    /**
     * 描述
     *
     * @return {String}
     */
    String value();
}

