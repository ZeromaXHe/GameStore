package com.zerox.frame.dao.impl;

import com.zerox.entity.domain.UserDO;
import com.zerox.frame.dao.UserDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 15:26
 */
@Repository
public class UserDAOMockImpl implements UserDAO {
    private int maxId = 0;
    Map<String, UserDO> userNameMap = new HashMap<>();

    @Override
    public UserDO getUser(String userName, String password) {
        UserDO userDO = userNameMap.get(userName);
        if (userDO == null || !password.equals(userDO.getPassword())) return null;
        else return userDO;
    }

    @Override
    public UserDO addUser(String userName, String password) {
        if (userNameMap.get(userName) != null) return null;
        UserDO newUser = new UserDO(maxId++);
        newUser.setUsername(userName);
        newUser.setPassword(password);
        userNameMap.put(userName, newUser);
        return newUser;
    }
}
