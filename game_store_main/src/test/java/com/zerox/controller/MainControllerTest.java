package com.zerox.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/27 17:29
 */
@SpringBootTest
public class MainControllerTest {
    @Autowired
    MainController mainController;

    @Test
    public void testMainLogin() {
        assertEquals("{\"flag\":\"0\",\"msg\":\"登录失败，请检查账号和密码！\"}",
                mainController.mainLogin("{\"username\":\"zzz\",\"password\":\"\"}"));
        assertEquals("{\"flag\":\"1\",\"msg\":\"登录成功！\"}",
                mainController.mainLogin("{\"username\":\"root\",\"password\":\"root\"}"));
    }
}
