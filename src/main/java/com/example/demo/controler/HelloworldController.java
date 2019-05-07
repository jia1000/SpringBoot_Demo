package com.example.demo.controler;

import com.example.demo.config.ServerConfig;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Department;
import com.example.demo.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloworldController {
    // org.apache.commons.logging.Log  日志的配置
    private Log log = LogFactory.getLog(HelloworldController.class);

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
    // JPA使用：5、数据表操作，如，插入、删除、修改等
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

    // JPA使用：6、建立查询函数接口
    // 得到user表中，某个id的用户数据
    @GetMapping("/user_query_view/{user_id}")
    public ModelAndView queryUserById(@PathVariable Integer user_id, ModelMap model) {
        User user = userRepository.findByid(user_id);
        // 使用模板库Freemarker，建立视图view
        ModelAndView view = new ModelAndView();
        // 给模板视图的变量， 设置新值
        view.addObject("user_id", user.getId());
        view.addObject("user_name", user.getName());
        // 设置模板视图的名称， 会自动添加后缀ftl
        view.setViewName("/user_statics");
        // 返回指向的模板文件
        return  view;
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

    // 返回一个测试用的HTML2文件,该html会是一个精简型，从0开始所需的功能
    @RequestMapping("/buffer_html2")
    public String showTestBufferHtml2() {
        return "/buffer2.html";
    }
    /// -----------读取应用配置-----------------------------------------------
    // 读取应用配置方式1：直接使用Environment，利用key-value获取。
    @Autowired private Environment env;
    public int getServerPortInt() {
        return  env.getProperty("server.port", Integer.class);
    }
    @RequestMapping("/server_port_by_env")
    @ResponseBody
    public String getServerPortByEnv() {
        return "server port by evn: " + getServerPortInt();
    }

    // 读取应用配置方式2：直接通过@Value注解，注入一个配置信息到Spring管理的Bean中
    @RequestMapping("/server_port_by_value")
    @ResponseBody
    public String getServerPortByValue(@Value("${server.port}") int port) {
        return "server port by value:" + port;
    }

    // 读取应用配置方式3：将一组同样类型的配置属性，映射为一个类。
    // 使用注解@ConfigurationProperties和@Configuration。
    @Autowired
    private ServerConfig serverconfig;

    @RequestMapping("/server_port_by_class")
    @ResponseBody
    public String getServerPortByClass() {
        return "server port by Class  1:" + serverconfig.getPort();
    }
}
