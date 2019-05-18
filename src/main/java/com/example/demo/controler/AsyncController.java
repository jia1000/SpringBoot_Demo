package com.example.demo.controler;

import com.example.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        asyncService.AsyncHandle1();
        return "success";
    }
}
