package com.wululu.wululu.service;

import com.wululu.wululu.entity.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wululu.wululu.mapper.userMapper;

@Service
public class userService {
    @Resource
    private userMapper userMapper;

    public void insert(User user){
        userMapper.insert(user);
    }
}
