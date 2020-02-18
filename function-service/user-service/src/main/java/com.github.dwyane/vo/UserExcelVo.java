package com.github.dwyane.vo;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.github.dwyane.excel.annotation.ExcelModel;
import lombok.Data;

/**
 * @ClassNanme: UserExcelVo
 * @Description: Excel用户数据
 * @Author: xujinzhao
 * @Date: 2020/2/17 20:29
 */
@Data
@ExcelModel("用户信息")
@ContentRowHeight(18)
@HeadRowHeight(20)
@ColumnWidth(15)
public class UserExcelVo {


}
