package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {

    // 第一个页
    @RequestMapping("/hello")
    @ResponseBody
    public String sayhello() {
        return "hello world .    this is first about Spirng Boot.";
    }

    // 第二个页
    @RequestMapping("/talk")
    @ResponseBody
    public String talk() {
        return "I'm talking.";
    }

    // 第三个页，带参数的请求
    @RequestMapping("/user/{id}")
    @ResponseBody
    public String getById(@PathVariable Long id) {
        return "user id : " + id;
    }
}
