package com.zerox.frame.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 10:15
 */
@EnableAutoConfiguration
@Controller
public class TemplateController {
    private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    /**
     * 登录页面
     *
     * @return 登录页面
     */
    @RequestMapping("/login")
    public String login() {
        logger.info("调用登录页面");
        return "login";
    }

    /**
     * 首页
     *
     * @return 首页
     */
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        logger.info("调用首页");
        return "index";
    }
}
