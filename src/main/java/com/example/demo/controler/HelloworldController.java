package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayhello() {
        return "hello world .    this is first about Spirng Boot.";
    }
}
