package com.wululu.wululu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wululu.wululu.mapper")
public class WululuApplication {

    public static void main(String[] args) {
        SpringApplication.run(WululuApplication.class, args);
    }

}
