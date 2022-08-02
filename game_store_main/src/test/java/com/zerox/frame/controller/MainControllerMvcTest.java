package com.zerox.frame.controller;

import com.zerox.constant.ReturnCode;
import com.zerox.constant.UserConstant;
import com.zerox.entity.business.DataBO;
import com.zerox.entity.view.RespDataVO;
import com.zerox.entity.view.UserVO;
import com.zerox.frame.service.UserService;
import com.zerox.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 18:29
 */
@WebMvcTest(MainController.class)
public class MainControllerMvcTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testValidation() throws Exception {
        when(userService.login(any(), any())).thenReturn(new DataBO(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.LOGIN_FAIL));
        when(userService.register(any(), any())).thenReturn(new DataBO(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.REGISTER_FAIL));
        mockMvc.perform(post("/user/login")
                        .contentType("application/json")
                        .content(Objects.requireNonNull(JsonUtils.objectToJson(new UserVO("zzz", "")))))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(Objects.requireNonNull(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.VALIDATION_FAIL.getCode(), "password 错误: 密码不能为空")))));
        mockMvc.perform(post("/user/login")
                        .contentType("application/json")
                        .content(Objects.requireNonNull(JsonUtils.objectToJson(new UserVO("", "")))))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(Objects.requireNonNull(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.VALIDATION_FAIL.getCode(),
                                // TODO: 使用 @GroupSequence 后，组与组之间属于快速失败，有待修改
                                "username 错误: 用户名不能为空"/* + "; password 错误: 密码不能为空"*/)))));
        mockMvc.perform(post("/user/login")
                        .contentType("application/json")
                        .content(Objects.requireNonNull(JsonUtils.objectToJson(new UserVO("root", "root")))))
                .andExpect(status().isOk())
                .andExpect(content().json(Objects.requireNonNull(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.LOGIN_FAIL)))));
        mockMvc.perform(post("/user/register")
                        .contentType("application/json")
                        .content(Objects.requireNonNull(JsonUtils.objectToJson(new UserVO("root", "root")))))
                .andExpect(status().isOk())
                .andExpect(content().json(Objects.requireNonNull(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.BUSINESS_FAIL.getCode(), UserConstant.REGISTER_FAIL)))));
        mockMvc.perform(post("/user/register")
                        .contentType("application/json")
                        .content(Objects.requireNonNull(JsonUtils.objectToJson(new UserVO("root", "")))))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(Objects.requireNonNull(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.VALIDATION_FAIL.getCode(), "password 错误: 密码不能为空")))));
    }

    @Test
    public void testInternalError() throws Exception {
        when(userService.login(any(), any())).thenThrow(new RuntimeException("mock error"));
        mockMvc.perform(post("/user/login")
                        .contentType("application/json")
                        .content(Objects.requireNonNull(JsonUtils.objectToJson(new UserVO("root", "root")))))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string(Objects.requireNonNull(JsonUtils.objectToJson(
                        new RespDataVO<String>(ReturnCode.INTERNAL_ERROR)))));
    }
}
