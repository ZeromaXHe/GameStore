package com.zerox.frame.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zerox.constant.ReturnCode;
import com.zerox.constant.UserConstant;
import com.zerox.entity.view.RespDataVO;
import com.zerox.entity.view.UserVO;
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
        // FIXME: 逻辑和实际代码有重复，感觉这样的单元测试写的有点问题。而且因为 Service 是真实的，所以应该属于集成测试的范围
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.LOGIN_FAIL))),
                mainController.login(new UserVO("zzz", "zzz")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.LOGIN_FAIL))),
                mainController.login(new UserVO("root", "root")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_OK.getCode(), UserConstant.REGISTER_SUCCESS))),
                mainController.register(new UserVO("root", "root")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.REGISTER_FAIL))),
                mainController.register(new UserVO("root", "redundant")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(
                        new RespDataVO<>(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.LOGIN_FAIL))),
                mainController.login(new UserVO("zzz", "zzz")));
        assertEquals(ResponseEntity.ok(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_OK.getCode(), UserConstant.LOGIN_SUCCESS))),
                mainController.login(new UserVO("root", "root")));
    }
}
