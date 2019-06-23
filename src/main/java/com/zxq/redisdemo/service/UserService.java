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
        long star=System.currentTimeMillis();
        for(int x=1003;x<2000;x++){
            user.setId(x);
            user.setName("测试"+x);
            userMapper.addUser(user);
        }
        System.out.println(System.currentTimeMillis()-star);
    }
}
