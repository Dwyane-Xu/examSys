package com.github.dwyane.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.converters.longconverter.LongStringConverter;
import com.github.dwyane.excel.annotation.ExcelModel;
import lombok.Data;

/**
 * @ClassNanme: MenuExcelVo
 * @Description: Excel菜单数据
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:38
 */
@Data
@ExcelModel("菜单信息")
@ContentRowHeight(18)
@HeadRowHeight(20)
@ColumnWidth(25)
public class MenuExcelVo {

    @ExcelProperty(value = "菜单id", converter = LongStringConverter.class)
    private Long id;

    @ExcelProperty("菜单名称")
    private String name;

    @ExcelProperty("权限标识")
    private String permission;

    @ExcelProperty("url")
    private String url;

    @ExcelProperty("重定向url")
    private String redirect;

    @ExcelProperty(value = "父菜单ID", converter = LongStringConverter.class)
    private Long parentId;

    @ExcelProperty("图标")
    private String icon;

    @ExcelProperty("排序号")
    private String sort;

    @ExcelProperty("类型")
    private String type;

    @ExcelProperty("模块")
    private String component;

    @ExcelProperty("路径")
    private String path;

    @ExcelProperty("备注")
    private String remark;
}
