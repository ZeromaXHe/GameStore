package com.zerox.entity.business;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/7/28 11:07
 */
public class UserBO {
    private String username;
    private String password;

    public UserBO(String username, String password) {
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
