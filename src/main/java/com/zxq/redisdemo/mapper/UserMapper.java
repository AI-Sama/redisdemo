package com.zxq.redisdemo.mapper;

import com.zxq.redisdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    void addUser(User user);
}
