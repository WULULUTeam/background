package com.wululu.wululu.controller;
import com.wululu.wululu.common.Result;
import org.springframework.web.bind.annotation.GetMapping;


import static javax.xml.transform.Result.*;

public class webController {
    @GetMapping("/")
    public Result hello(){
        return Result.success("访问成功！");
    }
}
