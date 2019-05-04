package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/strredis")
public class RedisStringController {

    @Autowired
    private StringRedisTemplate redisClient;

    // 操作pout的 Key-value
    @RequestMapping("/setget.html")
    public @ResponseBody String env() throws Exception {
        String para = "133";
        redisClient.opsForValue().set("testenv",  para);
        String str = redisClient.opsForValue().get("testenv");
        return str;
    }

    // 操作 List 结构,Hash  Set 类似
    @RequestMapping("redis_list")
    @ResponseBody
    public String redis_list_test() throws Exception {
        redisClient.opsForList().leftPush("message", "hello,xiandafu");
        redisClient.opsForList().leftPush("message", "hello, spring boot");

        return "add list of message.";
    }
    // 使用绑定key，操作 List 结构
    @RequestMapping("redis_bound_list")
    @ResponseBody
    public String redis_bound_list_test() throws Exception {
        BoundListOperations operations = redisClient.boundListOps("somekey");
        operations.leftPush("a");
        operations.leftPush("b");
        return String.valueOf(operations.size());
    }
    // 使用Sub/Pub
    @RequestMapping("redis_pub")
    @ResponseBody
    public String redis_pub_test() throws Exception {
        // 给Channel “news” ，发送一条消息。
        redisClient.convertAndSend("news", "hello,this is publish.");
        return "publish";
    }
}
