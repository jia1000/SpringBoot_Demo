package com.example.demo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @GetMapping("/showuser.html")
    public ModelAndView showUserInfo(Long id, String name) {
        ModelAndView view = new ModelAndView();

        // 给模板视图的变量， 设置新值
        view.addObject("id_in_template_ftl",   id);
        view.addObject("name_in_template_ftl", name);

        // 设置模板视图的名称， 会自动添加后缀ftl
        view.setViewName("/test_template");

        // 返回指向的模板文件
        return view;
    }
}
