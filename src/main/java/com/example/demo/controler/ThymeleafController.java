package com.example.demo.controler;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("hello")
    public String sayHello(Map<String, Object> map) {
        map.put("msg", "hello Thymeleaf");
        return "test_thymeleaf";
    }

    @RequestMapping("hello2")
    public String sayHello2(WebRequest webRequest) {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        users.add(user);

        User user2 = new User();
        user2.setId(2);
        user2.setName("lisi");
        users.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("wangmazi");
        users.add(user3);

        webRequest.setAttribute("users", users, webRequest.SCOPE_REQUEST);

        return "test_thymeleaf2";
    }
}
