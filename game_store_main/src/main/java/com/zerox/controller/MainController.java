package com.zerox.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZeromaXHe
 * @date 2020/7/18 16:11
 */
@EnableAutoConfiguration
@Controller
public class MainController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 加上@ResponseBody注解的方法，返回字符串。不加则使用thymeleaf模板返回html网页
     * @return 字符串
     */
    @RequestMapping("/returnString")
    @ResponseBody
    public String returnString(){
        return "returnString";
    }
}
