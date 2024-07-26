package com.wululu.wululu.entity;

/**
 * 角色用户父类*/
public class Account {
    // 唯一id
    private Integer id;
    //用户名
    private String name;
    //其他平台关联的用户id
    private String accountId;
    //密码
    private String password;
    //用于标识管理员、普通用户和攻略组
    private String role;
    //头像
    private String avatar;
    //用于使用其他平台账户登录的一个令牌之类的
    private String token;
    //用户简介
    private String info;
}
