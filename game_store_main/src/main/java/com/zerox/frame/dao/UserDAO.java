package com.zerox.frame.dao;

import com.zerox.entity.domain.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 15:26
 */
public interface UserDAO extends JpaRepository<UserDO, Integer> {
    UserDO findByUsernameAndPassword(String username, String password);
    UserDO findByUsername(String username);
}
