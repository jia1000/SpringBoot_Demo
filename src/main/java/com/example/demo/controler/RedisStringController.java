package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/strredis")
public class RedisStringController {

    @Autowired
    private StringRedisTemplate redisClient;

    @RequestMapping("/setget.html")
    public @ResponseBody String env() throws Exception {
        String para = "133";
        redisClient.opsForValue().set("testenv",  para);
        String str = redisClient.opsForValue().get("testenv");
        return str;
    }
}
