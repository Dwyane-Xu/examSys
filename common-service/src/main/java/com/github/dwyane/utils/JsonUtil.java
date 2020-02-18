package com.github.dwyane.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @ClassNanme: JsonUtil
 * @Description: Json转化工具
 * @Author: xujinzhao
 * @Date: 2020/2/12 15:03
 */
@Slf4j
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            log.warn("Object to json failed: " + object, e);
            return null;
        }
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            log.warn("Json to object failed: " + jsonString, e);
            return null;
        }
    }

    public static <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return (T) objectMapper.readValue(jsonString, javaType);
        } catch (IOException e) {
            log.warn("Json to object failed: " + jsonString, e);
            return null;
        }
    }

    public static Object fromJsonObject(String jsonString, JavaType javaType) {
        return fromJson(jsonString, javaType);
    }
}
