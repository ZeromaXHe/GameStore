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
    @RequestMapping("/start")
    @ResponseBody
    public String start(){
        return "Start game store web site";
    }
}
