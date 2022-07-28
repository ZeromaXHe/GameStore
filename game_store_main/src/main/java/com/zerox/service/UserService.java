package com.zerox.service;

import com.zerox.entity.business.DataBO;
import com.zerox.entity.business.UserBO;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 10:36
 */
public interface UserService {
    DataBO login(UserBO userBO);
}
