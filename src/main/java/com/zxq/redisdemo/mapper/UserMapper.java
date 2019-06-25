package com.zxq.redisdemo.mapper;

import com.zxq.redisdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    void addUser(User user);
    List<User> findUsers();
}
