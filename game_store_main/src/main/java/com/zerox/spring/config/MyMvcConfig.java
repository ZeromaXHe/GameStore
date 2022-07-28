package com.zerox.spring.config;

import com.zerox.spring.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 14:28
 */
@Configuration
public class MyMvcConfig {

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }
}
