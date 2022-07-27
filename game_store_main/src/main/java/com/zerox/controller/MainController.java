package com.zerox.controller;

import com.zerox.entity.DataDTO;
import com.zerox.entity.UserDTO;
import com.zerox.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZeromaXHe
 * @date 2020/7/18 16:11
 */
@EnableAutoConfiguration
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

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

    @PostMapping("/mainLogin")
    @ResponseBody
    public String mainLogin(@RequestParam String inputJson) {
        logger.info("inputJson: {}", inputJson);
        UserDTO userDTO = JsonUtils.jsonToObject(inputJson, UserDTO.class);
        DataDTO dataDTO = new DataDTO();
        if ("root".equals(userDTO.getUsername()) && "root".equals(userDTO.getPassword())) {
            dataDTO.setFlag("1");
            dataDTO.setMsg("登录成功！");
        } else {
            dataDTO.setFlag("0");
            dataDTO.setMsg("登录失败，请检查账号和密码！");
        }
        String output = JsonUtils.objectToJson(dataDTO);
        logger.info("output:{}", output);
        return output;
    }

    /**
     * 加上@ResponseBody注解的方法，返回字符串。不加则使用thymeleaf模板返回html网页
     *
     * @return 字符串
     */
    @RequestMapping("/returnString")
    @ResponseBody
    public String returnString() {
        logger.info("调用returnString方法");
        return "returnString";
    }
}
