package com.example.demo.controler;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloworldController {
    @Autowired
    private UserRepository userRepository;

    /// 可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    //  通过 @Autowired的使用来消除 set ，get方法。
    // 没加该注解，写数据表，会失败
    @Autowired
    private DepartmentRepository departmentRepository;

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
    /// ------------user表的操作----------------------------------------------
    // 添加用户，到数据表中
    @RequestMapping("adduser/{user_name}")
    @ResponseBody
    public String addUser(@PathVariable String user_name) {
        User user = new User();
        user.setName(user_name);

        userRepository.save(user);
        return "user name : " + user_name;
    }

    // 得到user 数据表的数量
    @RequestMapping("user_count")
    @ResponseBody
    public String getUserCount() {
        Long rowCount = userRepository.count();
        String ret = "user's count = " + rowCount;
        return ret;
    }

    // 删除user表， 某个id    不成功
    @RequestMapping("user_delete/{user_id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer user_id) {
        userRepository.deleteById(user_id);
        return "deleted user id : " + user_id;
    }

    // 得到user表中，某个用户的id
    @RequestMapping("user_query_id/{user_name}")
    @ResponseBody
    public String queryUserId(@PathVariable String user_name) {
        User user = userRepository.findByName(user_name);
        return user_name + "'s id is " + user.getId();
    }

    // 得到user表中，某个id的用户的名称
    @RequestMapping("user_query_name/{user_id}")
    @ResponseBody
    public String queryUserName(@PathVariable Integer user_id) {
        User user = userRepository.findByid(user_id);
        return user_id + "'s name is " + user.getName();
    }

    /// ------------department表的操作----------------------------------------------
    // 添加用户，到数据表中
    @RequestMapping("add_department/{department_name}")
    @ResponseBody
    public String addDepartment(@PathVariable String department_name) {

        Department department = new Department();
        department.setName(department_name);


        departmentRepository.save(department);

        return "department name : " + department.getName() + "  id :" + department.getId();
    }

    /// ----------------------------------------------------------
    // 返回一个测试用的HTML文件
    @RequestMapping("/windows_binding_html")
    public String showTestHtml() {
        return "/windows_binding.html";
    }

    // 返回一个测试用的HTML2文件
    @RequestMapping("/buffer_html")
    public String showTestBufferHtml() {
        return "/buffer.html";
    }
}
