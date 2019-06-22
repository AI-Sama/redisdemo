package com.zxq.redisdemo.controller;

import com.zxq.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    UserService userService;
    @RequestMapping("/Demo")
    public String Demo(){
        userService.addUser();
        return "test1.html";
    }
}
