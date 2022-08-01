package com.zerox.frame.service;

import com.zerox.entity.business.DataBO;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 10:36
 */
public interface UserService {
    DataBO login(String userName, String password);

    DataBO register(String userName, String password);
}
