package com.zerox.spring;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 14:06
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求（a 标签）中携带的地区参数。
        String language = request.getParameter("l");
        // 获取默认的地区参数
        Locale locale = Locale.getDefault();
        // 如果不为空地区参数为获取的地区参数
        if (StringUtils.hasLength(language)) {
            String[] split = language.split("_");
            if (split.length == 2) {
                locale = new Locale(split[0], split[1]);
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // 此处留空
    }
}
