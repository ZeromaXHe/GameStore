package com.zerox.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/27 17:08
 */
public class JsonUtils {
    // Jackson 的 ObjectMapper 在配置不修改的情况下是线程安全的，详情请在源码中搜索 thread-safe
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T jsonToObject(String json, Class<T> objectClass) {
        try {
            return mapper.readValue(json, objectClass);
        } catch (JsonProcessingException e) {
            // TODO: 异常处理逻辑
            return null;
        }
    }

    public static String objectToJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            // TODO: 异常处理逻辑
            return null;
        }
    }
}
