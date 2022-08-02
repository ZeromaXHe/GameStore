package com.zerox.entity.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhuxi
 * @apiNote
 * @implNote
 * @since 2022/8/1 15:28
 */
@Entity
@Table(name = "user_tbl")
public class UserDO {
    @Id
    @GeneratedValue(generator = "userIdGen", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "userIdGen", strategy = "native")
    private Integer id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    public UserDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
