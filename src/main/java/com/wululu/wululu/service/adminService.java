package com.wululu.wululu.service;

import com.wululu.wululu.entity.Admin;
import com.wululu.wululu.entity.User;
import jakarta.annotation.Resource;
import com.wululu.wululu.mapper.adminMapper;
import org.springframework.stereotype.Service;

@Service
public class adminService {
    @Resource
    private adminMapper adminMapper;

    public void insert(Admin admin){
        adminMapper.insert(admin);
    }
}
