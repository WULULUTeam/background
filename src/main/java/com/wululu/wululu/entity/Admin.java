package com.wululu.wululu.entity;

import java.io.Serial;
import java.io.Serializable;
/**
 * 管理员*/
public class Admin extends Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getToken() {
        return token;
    }

    private String accountId;
    private String password;
    private String role;
    private String avatar;
    private String token;
    private String info;
}
