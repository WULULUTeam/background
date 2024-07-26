package com.wululu.wululu.controller;

import com.wululu.wululu.common.Result;
import com.wululu.wululu.entity.Admin;
import com.wululu.wululu.entity.User;
import com.wululu.wululu.service.userService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class userController {
    @Resource
    private userService userService;

    @PostMapping("/insert")
    public Result add(@RequestBody User user) {
        userService.insert(user);
        return Result.success("插入成功！");
    }
}
