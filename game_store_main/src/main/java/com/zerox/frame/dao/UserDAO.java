package com.zerox.frame.dao;

import com.zerox.entity.domain.UserDO;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 15:26
 */
public interface UserDAO {
    UserDO getUser(String userName, String password);

    UserDO addUser(String userName, String password);
}
