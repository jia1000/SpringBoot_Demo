package com.example.demo.controler.admin;

import com.example.demo.dao.blog.TableTbBlogMapper;
import com.example.demo.entity.blog.TableTbBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private TableTbBlogMapper tableTbBlogMapper;

    // 解决中文乱码
    @RequestMapping(value="/getblog/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    @Transactional
    public String getBlog(@PathVariable Long id) {
        TableTbBlog blog_item = tableTbBlogMapper.selectByPrimaryKey(id);
        String content = blog_item.getBlog_content();
        System.out.println("content: ");
        return "blog's content : " + content;
    }

    @RequestMapping("/blogs")
    public String showAllBlogsWithHtml(Model model) throws Exception {
        List<TableTbBlog> blogs = tableTbBlogMapper.getLists();

        model.addAttribute("headtext", "Blog List:");
        model.addAttribute("blogs", blogs);
        return "blog_thymeleaf";
    }

    // 响应从html网页中的事件
    @RequestMapping("blogs/edit")
    public String edit(){//HttpServletRequest request) {
        return "blog/edit";
    }

    // 响应从html网页中的事件
    @RequestMapping("blogs/save")
    public String saveBlog(HttpServletRequest request) {
        String blogNmae = request.getParameter("blogName");
        System.out.println("haha :blogNmae : " + blogNmae);
        return "blog/save";
    }

    @RequestMapping("/ele")
    public String showElementUI() {
        return "blog/element_ui_test";
    }

}
