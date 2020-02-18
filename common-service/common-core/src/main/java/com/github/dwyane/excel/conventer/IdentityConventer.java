package com.github.dwyane.excel.conventer;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.github.dwyane.enums.IdentityEnum;

/**
 * @ClassNanme: IdentityConventer
 * @Description: 用户授权类型转换器
 * @Author: xujinzhao
 * @Date: 2020/2/17 22:59
 */
public class IdentityConventer implements Converter<Integer> {

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
                                     GlobalConfiguration globalConfiguration) throws Exception {
        return IdentityEnum.matchByDesc(cellData.getStringValue()).getValue();
    }

    @Override
    public CellData<String> convertToExcelData(Integer value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(IdentityEnum.matchByType(value).getDesc());
    }
}
