package com.github.dwyane.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassNanme: ExcelModel
 * @Description: 导入的Excel文件
 * @Author: xujinzhao
 * @Date: 2020/2/17 21:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelModel {

    /**
     * 模块名，用于导出时的文件名
     * @return String
     */
    String value() default "";

    /**
     * 页名
     * @return String
     */
    String[] sheets() default {"sheet1"};

}
