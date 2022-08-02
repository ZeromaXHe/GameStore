package com.zerox.frame.controller;

import com.zerox.entity.view.RespDataVO;
import com.zerox.entity.view.UserVO;
import com.zerox.frame.service.UserService;
import com.zerox.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZeromaXHe
 * @since 2020/7/18 16:11
 */
@EnableAutoConfiguration
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@RequestBody @Validated({UserVO.UserCheckSequence.class}) UserVO userVO) {
        logger.info("inputJson: {}", JsonUtils.objectToJson(userVO));
        RespDataVO<String> result = userService.login(userVO.getUsername(), userVO.getPassword()).toRespDataVO();
        String output = JsonUtils.objectToJson(result);
        logger.info("output:{}", output);
        return ResponseEntity.ok(output);
    }

    @PostMapping("/user/register")
    public ResponseEntity<String> register(@RequestBody @Validated({UserVO.UserCheckSequence.class}) UserVO userVO) {
        logger.info("inputJson: {}", JsonUtils.objectToJson(userVO));
        RespDataVO<String> result = userService.register(userVO.getUsername(), userVO.getPassword()).toRespDataVO();
        String output = JsonUtils.objectToJson(result);
        logger.info("output:{}", output);
        return ResponseEntity.ok(output);
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
