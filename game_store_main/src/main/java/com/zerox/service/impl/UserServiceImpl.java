package com.zerox.service.impl;

import com.zerox.entity.business.DataBO;
import com.zerox.entity.business.UserBO;
import com.zerox.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 10:37
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public DataBO login(UserBO userBO) {
        if ("root".equals(userBO.getUsername()) && "root".equals(userBO.getPassword())) {
            return new DataBO("1", "登录成功！");
        } else {
            return new DataBO("0", "登录失败，请检查账号和密码！");
        }
    }
}
