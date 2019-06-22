package com.zxq.redisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisdemoApplication.class, args);
    }
}
