package com.zerox.spring.config;

import com.zerox.spring.resolver.MyLocalResolver;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.LocaleResolver;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidator(validator());
        return processor;
    }

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(false)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
