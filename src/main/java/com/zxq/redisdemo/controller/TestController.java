package com.zxq.redisdemo.controller;

import com.zxq.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    UserService userService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/Demo")
    public String Demo(){
           stringRedisTemplate.opsForValue().set("aaa","zxq");
           System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
//        userService.addUser();
        return "test1.html";
    }
}
