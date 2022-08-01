package com.zerox.frame.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zerox.constant.UserConstant;
import com.zerox.entity.view.DataVO;
import com.zerox.entity.view.UserVO;
import com.zerox.frame.service.UserService;
import com.zerox.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

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
    public void testLoginAndRegister() {
        // FIXME: 逻辑和实际代码有重复。感觉这样的单元测试写的有点问题
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(new DataVO("0", UserConstant.LOGIN_FAIL))),
                mainController.login(new UserVO("zzz", "")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(new DataVO("0", UserConstant.LOGIN_FAIL))),
                mainController.login(new UserVO("root", "root")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(new DataVO("1", UserConstant.REGISTER_SUCCESS))),
                mainController.register(new UserVO("root", "root")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(new DataVO("0", UserConstant.REGISTER_FAIL))),
                mainController.register(new UserVO("root", "redundant")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(new DataVO("0", UserConstant.LOGIN_FAIL))),
                mainController.login(new UserVO("zzz", "")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(new DataVO("1", UserConstant.LOGIN_SUCCESS))),
                mainController.login(new UserVO("root", "root")));
    }
}
