package com.zxq.redisdemo.service;

import com.zxq.redisdemo.bean.User;
import com.zxq.redisdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public void addUser(){
        User user=new User();
        long star=System.currentTimeMillis();
        System.out.println(System.currentTimeMillis()-star);
    }
    public List<User> findUsers(){
      return findUsers();
    }
}
