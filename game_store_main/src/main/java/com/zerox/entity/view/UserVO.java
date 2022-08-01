package com.zerox.entity.view;

/**
 * @author ZeromaXHe
 * @apiNote 用户 VO
 * @since 2020/7/19 17:55
 */
public class UserVO {
    private String username;
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
}
