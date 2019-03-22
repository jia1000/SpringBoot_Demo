package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // 使用ModelAttribute注解， 意味着，该方法会首先被调用，并将该方法作为Model的属性，然后再调用对应的Controller处理方法；
    @ModelAttribute
    public void findUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", "zhangsan");
        System.out.println("enter function : findUserById.");
    }

    @GetMapping(path="/{id}/get.json")
    @ResponseBody
    public String GetUser(Model model) {
        System.out.print(model.containsAttribute("user"));
        System.out.println(model.toString());
        System.out.println("enter function : GetUser.");
        return "Success";

    }
}
