package com.zxq.redisdemo.controller;
import com.zxq.redisdemo.bean.User;
import com.zxq.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.concurrent.TimeUnit;

@Controller
public class TestController {
    @Autowired
    UserService userService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/Demo")
    public String Demo() throws Exception{
        User user=new User();
        user.setId(3);
        user.setName("zxq");
//      stringRedisTemplate.opsForValue().set();
        redisTemplate.opsForValue().set("user",user,1,TimeUnit.SECONDS);//向value中存入对象并设置过期时间为1s
        redisTemplate.opsForValue().set("str","123132");
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("str"));
        Thread.sleep(10000);
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("str"));
//        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
//        userService.addUser();
        return "test1.html";
    }
}
