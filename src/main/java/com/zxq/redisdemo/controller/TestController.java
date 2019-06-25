package com.zxq.redisdemo.controller;
import com.zxq.redisdemo.bean.User;
import com.zxq.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

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
        List<User> users=new ArrayList<>();
        for(int x=0;x<100;x++){
            User user=new User();
            user.setId(x);
            user.setName("zxq"+x);
            users.add(user);
        }
        redisTemplate.opsForValue().set("key1",users);//储存对象
        List<User> users2=(List<User>) redisTemplate.opsForValue().get("key1");//查找redis中存入的对象，转化为指定类型
        System.out.println(redisTemplate.opsForValue().get("key1"));
        System.out.println(users2);
        return "test1.html";
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public String  addUser(Integer id,String name){
        System.out.println(1);
            User user=new User();
            user.setId(id);
            user.setName(name);
            redisTemplate.opsForValue().set("user",user);
            return "添加成功";
    }
    @RequestMapping("/findUser")
    @ResponseBody
    public String  findUser(){
        System.out.println(2);
         System.out.println(redisTemplate.opsForValue().get("user"));
         return "成功";
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(){
        System.out.println(3);
           redisTemplate.delete("user");
        System.out.println(redisTemplate.opsForValue().get("user"));
        return "删除成功";
    }
    @RequestMapping("/testRedis")
    @ResponseBody
    public String testRedis(){//效率测试
                User user=new User();
                user.setId(1);
                user.setName("zxq");
                long star=System.currentTimeMillis();
                System.out.println(star);
                for (int x=0;x<10000;x++){
                    redisTemplate.opsForValue().set("key","123");
                }
                 System.out.println(System.currentTimeMillis()-star);//用时2秒
        return "OK";
    }
}
