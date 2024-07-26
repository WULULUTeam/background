package com.wululu.wululu.controller;
import com.wululu.wululu.entity.Admin;
import com.wululu.wululu.service.adminService;
import com.wululu.wululu.common.Result
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class adminController {
    @PostMapping("/add")
    public Result add(@RequestBody Admin admin){
        adminService.insert(admin);
        return Result.success("插入成功！");
    }
}
