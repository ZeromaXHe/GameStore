package com.zerox.entity.view;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;

/**
 * @author ZeromaXHe
 * @apiNote 用户 VO
 * @since 2020/7/19 17:55
 */
public class UserVO {
    @NotEmpty(message = "用户名不能为空", groups = {UsernameCheck.class})
    private String username;
    @NotEmpty(message = "密码不能为空", groups = {PasswordCheck.class})
    private String password;

    public UserVO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public interface UsernameCheck {
    }

    public interface PasswordCheck {
    }

    @GroupSequence({UsernameCheck.class, PasswordCheck.class})
    public interface UserCheckSequence {
    }
}
