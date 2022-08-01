package com.zerox.entity.domain;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 15:28
 */
public class UserDO {
    private Integer userId;
    private String username;
    private String password;

    public UserDO(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
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
