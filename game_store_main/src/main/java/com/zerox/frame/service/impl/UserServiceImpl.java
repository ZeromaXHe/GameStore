package com.zerox.frame.service.impl;

import com.zerox.constant.UserConstant;
import com.zerox.entity.business.DataBO;
import com.zerox.entity.domain.UserDO;
import com.zerox.frame.dao.UserDAO;
import com.zerox.frame.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 10:37
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public DataBO login(String userName, String password) {
        UserDO user = userDAO.getUser(userName, password);
        if (user != null) {
            return new DataBO("1", UserConstant.LOGIN_SUCCESS);
        } else {
            return new DataBO("0", UserConstant.LOGIN_FAIL);
        }
    }

    @Override
    public DataBO register(String userName, String password) {
        UserDO user = userDAO.addUser(userName, password);
        if (user != null) {
            return new DataBO("1", UserConstant.REGISTER_SUCCESS);
        } else {
            return new DataBO("0", UserConstant.REGISTER_FAIL);
        }
    }
}
