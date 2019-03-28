package com.example.demo.controler;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloworldController {
    @Autowired
    private UserRepository userRepository;

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

    // 该函数中，有id，会造成 其它PathVariable的类型，不是Long类型，会出问题。
    // 使用ModelAttribute注解， 意味着，该方法会首先被调用，并将该方法作为Model的属性，然后再调用对应的Controller处理方法；
    //@ModelAttribute
    //public void findUserById(@PathVariable Long id, Model model) {
    //    model.addAttribute("user", "zhangsan");
    //    System.out.println("enter function : findUserById.");
    //}

    @GetMapping(path="/{id}/get.json")
    @ResponseBody
    public String GetUser(Model model) {
        System.out.print(model.containsAttribute("user"));
        System.out.println(model.toString());
        System.out.println("enter function : GetUser.");
        return "Success";
    }

    // 添加用户，到数据表中
    @RequestMapping("adduser/{user_name}")
    @ResponseBody
    public String addUser(@PathVariable String user_name) {
        User user = new User();
        user.setName(user_name);

        userRepository.save(user);
        return "user name : " + user_name;
    }

}
