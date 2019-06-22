package com.zxq.redisdemo.service;

import com.zxq.redisdemo.bean.User;
import com.zxq.redisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public void addUser(){
        User user=new User();
        user.setId(2);
        user.setName("李四");
          userMapper.addUser(user);
    }
}
