package com.github.dwyane.excel.conventer;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.github.dwyane.enums.GenderEnum;

/**
 * @ClassNanme: GenderConventer
 * @Description: 性别转换器
 * @Author: xujinzhao
 * @Date: 2020/2/17 21:35
 */
public class GenderConventer implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                     GlobalConfiguration globalConfiguration) {
        return GenderEnum.matchByName(cellData.getStringValue()).getValue();
    }

    @Override
    public CellData<String> convertToExcelData(Integer value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) {
        return new CellData(GenderEnum.matchByValue(value).getName());
    }
}
